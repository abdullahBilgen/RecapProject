package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.AllFindexPointCheckService;
import com.example.reCapProject.business.abstracts.RentalService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.dataAccess.abstracts.CarDao;
import com.example.reCapProject.dataAccess.abstracts.CarRepairDao;
import com.example.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.example.reCapProject.dataAccess.abstracts.CustomerDao;
import com.example.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.example.reCapProject.dataAccess.abstracts.RentalDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarRepair;
import com.example.reCapProject.entities.concretes.CorporateCustomer;
import com.example.reCapProject.entities.concretes.IndividualCustomer;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.dtos.RentalDetailsDto;
import com.example.reCapProject.entities.request.create.CreateRentalRequest;
import com.example.reCapProject.entities.request.update.UpdateRentalRequest;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private CarDao carDao;
	private CustomerDao customerDao;
	private IndividualCustomerDao individualCustomerDao;
	private CorporateCustomerDao corporateCustomerDao;
	private AllFindexPointCheckService allFindexPointCheckService;
	private CarRepairDao carRepairDao;

	@Autowired
	public RentalManager(RentalDao rentalDao, CarDao carDao, CustomerDao customerDao,
			IndividualCustomerDao individualCustomerDao, CorporateCustomerDao corporateCustomerDao,
			AllFindexPointCheckService allFindexPointCheckService,CarRepairDao carRepairDao) {
	  super();
	  this.rentalDao = rentalDao;
	  this.carDao = carDao;
	  this.customerDao = customerDao;
	  this.individualCustomerDao = individualCustomerDao;
	  this.allFindexPointCheckService = allFindexPointCheckService;
	  this.corporateCustomerDao = corporateCustomerDao;
	  this.carRepairDao=carRepairDao;
	
	}
	
	@Override
	public DataResult<List<Rental>> getAll() {
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll(), Messages.RENTALDATESUCCESS);
	}

	@Override
	public DataResult<Rental> getById(int rentalId) {
		return new SuccessDataResult<Rental>(this.rentalDao.getById(rentalId), Messages.RENTALDATESUCCESS);
	}

	@Override
	public Result addCorporateCustomer(CreateRentalRequest createRentalRequest) {
		Car car = this.carDao.getById(createRentalRequest.getCarId());
		car.setCity(createRentalRequest.getDeliveryCity());
		this.carDao.save(car);

		CorporateCustomer corporateCustomer= new CorporateCustomer();
		corporateCustomer.setUserId(createRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()),
				checkCorporateCustomerFindexPoint(this.corporateCustomerDao.getById(createRentalRequest.getCustomerId()),
				this.carDao.getById(createRentalRequest.getCarId())),checkIsCarCare(createRentalRequest.getCarId()));

		if (result != null) {
			return result;
		}
		Rental rental = new Rental();
		rental.setPickUpCity(car.getCity());
		rental.setDeliveryCity(createRentalRequest.getDeliveryCity());
		rental.setRentDate(createRentalRequest.getRentDate());
		rental.setStartingMileage(createRentalRequest.getStartingMileage());
		rental.setCar(car);
		rental.setCustomer(corporateCustomer);
		

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALADD);
	}

	@Override
	public Result addIndividualCustomer(CreateRentalRequest createRentalRequest) {
		Car car = this.carDao.getById(createRentalRequest.getCarId());
		car.setCity(createRentalRequest.getDeliveryCity());
		this.carDao.save(car);
		
		IndividualCustomer individualCustomer= new IndividualCustomer();
		individualCustomer.setUserId(createRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()),
				checkİndiviualCustomerFindexPoint(
		this.individualCustomerDao.getById(createRentalRequest.getCustomerId()),
		this.carDao.getById(createRentalRequest.getCarId())),checkIsCarCare(createRentalRequest.getCarId()));
		
		if (result != null) {
			return result;
		}
		
		Rental rental = new Rental();
		rental.setPickUpCity(car.getCity());
		rental.setDeliveryCity(createRentalRequest.getDeliveryCity());
		rental.setRentDate(createRentalRequest.getRentDate());
		rental.setCar(car);
		rental.setCustomer(individualCustomer);
		rental.setReturnDate(createRentalRequest.getReturnDate());
		rental.setStartingMileage(createRentalRequest.getStartingMileage());
		
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALADD);
	}

	@Override
	public Result updateCorporateCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car = this.carDao.getById(updateRentalRequest.getCarId());
		car.setCity(updateRentalRequest.getDeliveryCity());
		this.carDao.save(car);

		CorporateCustomer corporateCustomer= new CorporateCustomer();
		corporateCustomer.setUserId(updateRentalRequest.getCustomerId());
		
		var result = BusinessRules.run(checkCorporateCustomerFindexPoint(
		this.corporateCustomerDao.getById(updateRentalRequest.getCustomerId()),
		this.carDao.getById(updateRentalRequest.getCarId())));
		
		if (result != null) {
			return result;
		}
		
		Rental rental = this.rentalDao.getById(updateRentalRequest.getCarId());
		rental.setPickUpCity(car.getCity());
		rental.setDeliveryCity(updateRentalRequest.getDeliveryCity());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setReturnStatus(updateRentalRequest.isReturnStatus());
		rental.setCar(car);
		rental.setCustomer(corporateCustomer);
		rental.setStartingMileage(updateRentalRequest.getStartingMileage());

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALUPDATE);
	}

	@Override
	public Result updateIndividualCustomer(UpdateRentalRequest updateRentalRequest) {
		Car car = this.carDao.getById(updateRentalRequest.getCarId());
		car.setCity(updateRentalRequest.getDeliveryCity());
		this.carDao.save(car);


		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setUserId(updateRentalRequest.getCustomerId());

		var result = BusinessRules.run(checkİndiviualCustomerFindexPoint(
		this.individualCustomerDao.getById(updateRentalRequest.getCustomerId()),
		this.carDao.getById(updateRentalRequest.getCarId())));
		
		if (result != null) {
			return result;
		}

		Rental rental = this.rentalDao.getById(updateRentalRequest.getCarId());
		rental.setPickUpCity(car.getCity());
		rental.setDeliveryCity(updateRentalRequest.getDeliveryCity());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setCar(car);
		rental.setCustomer(individualCustomer);
		rental.setReturnStatus(updateRentalRequest.isReturnStatus());
		rental.setStartingMileage(updateRentalRequest.getStartingMileage());

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RENTALUPDATE);
	}

	private Result checkCarIsReturned(int carId) {

		RentalDetailsDto rentalDetailsDto = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (rentalDetailsDto != null) {
			return new ErrorResult(Messages.RENTALDATEERROR);
		}
		return new SuccessResult();

	}

	private Result checkİndiviualCustomerFindexPoint(IndividualCustomer individualCustomer, Car car) {

		if (this.allFindexPointCheckService.checkIndividualCustomerFindexPoint(individualCustomer) <= car
				.getCarFindeks()) {
			return new ErrorResult(Messages.ERROR);
		}
		return new SuccessResult();
	}

	private Result checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer, Car car) {

		if (this.allFindexPointCheckService.checkCorporateCustomerFindexPoint(corporateCustomer) <= car
				.getCarFindeks()) {

			return new ErrorResult(Messages.ERROR);
		}
		return new SuccessResult();
	}
	
	private Result checkIsCarCare(int carId) {
		if (this.carRepairDao.getByCar_CarId(carId).size() != 0) {
			CarRepair carRepair= this.carRepairDao.getByCar_CarId(carId)
					.get(this.carRepairDao.getByCar_CarId(carId).size()-1);
			
			if (carRepair.getReturnDate()==null) {
				return new ErrorResult(Messages.RENTREPAIRERROR);
			 }
			
		}
		return new SuccessResult();
    }

}