package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.RentalService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.dataAccess.abstracts.RentalDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.CreateRentalRequest;
import com.example.reCapProject.entities.request.DeleteRentalRequest;
import com.example.reCapProject.entities.request.UpdateRentalRequest;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;

	@Autowired
	public RentalManager(RentalDao rentalDao) {
		super();
		this.rentalDao = rentalDao;
	}

	@Override
	public DataResult<List<Rental>> getAll() {
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll(), Messages.GETALL);
	}

	@Override
	public DataResult<Rental> getById(int rentalId) {
		return new SuccessDataResult<Rental>(this.rentalDao.getById(rentalId), Messages.GETID);
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		
		var result = BusinessRules.run(checkCarIsReturned());

		if (result != null) {
			return result;
		}


		Car car = new Car();
		car.setCarId(createRentalRequest.getCarId());

		Customer customer = new Customer();
		customer.setUserId(createRentalRequest.getCustomerId());

		Rental rental = new Rental();
		rental.setRentDate(createRentalRequest.getRentDate());
		
		rental.setCar(car);
		rental.setCustomer(customer);
		
		
		rental.setCar(car);
		rental.setCustomer(customer);
		
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		
		Car car = new Car();
		car.setCarId(updateRentalRequest.getCarId());
		
		Customer customer = new Customer();
		customer.setUserId(updateRentalRequest.getCustomerId());
		
		Rental rental = new Rental();
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());
		rental.setCar(car);
		rental.setCustomer(customer);
		rental.setReturnRentControl(updateRentalRequest.isRentStatus());
		
		this.rentalDao.save(rental);
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		
		Car car = new Car();
		car.setCarId(deleteRentalRequest.getCarId());
		
		Customer customer = new Customer();
		customer.setUserId(deleteRentalRequest.getCustomerId());
		
		Rental rental = new Rental();
		rental.setRentDate(deleteRentalRequest.getRentDate());
		rental.setReturnDate(deleteRentalRequest.getReturnDate());
		rental.setCar(car);
		rental.setCustomer(customer);
		rental.setReturnRentControl(deleteRentalRequest.isRentStatus());
		
		this.rentalDao.delete(rental);
		return new SuccessResult(Messages.DELETE);
	}

	private Result checkCarIsReturned() {

		if (this.rentalDao.existsByReturnRentControlIsFalse()) {
				return new ErrorResult(Messages.ERROR);
			
		}
		return new SuccessResult();
	}

}