package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarRepairService;
import com.example.reCapProject.business.abstracts.CarService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarRepairDao;
import com.example.reCapProject.dataAccess.abstracts.RentalDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarRepair;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreateCarRepairRequest;

import com.example.reCapProject.entities.request.delete.DeleteCarRepairRequest;

import com.example.reCapProject.entities.request.update.UpdateCarRepairRequest;

@Service
public class CarRepairManager implements CarRepairService {

	private CarRepairDao carRepairDao;
	private RentalDao rentalDao;
	private CarService carService;

	@Autowired
	public CarRepairManager(CarRepairDao carRepairDao, RentalDao rentalDao) {
		super();
		this.carRepairDao = carRepairDao;
		this.rentalDao = rentalDao;
	}

	@Override
	public DataResult<CarRepair> getById(int carRepairId) {
		return new SuccessDataResult<CarRepair>(this.carRepairDao.getById(carRepairId), Messages.REPAIRID);
	}

	@Override
	public DataResult<List<CarRepair>> getAll() {
		return new SuccessDataResult<List<CarRepair>>(this.carRepairDao.findAll(), Messages.REPAIRLIST);
	}

	@Override
	public Result add(CreateCarRepairRequest createCarRepairRequest) {

		var result = BusinessRules.run(checkIfCarRented(createCarRepairRequest.getCarId()));

		if (result != null) {
			return result;
		}

		Car car = new Car();
		car.setCarId(createCarRepairRequest.getCarId());

		CarRepair carRepair = new CarRepair();
		carRepair.setRepairDate(createCarRepairRequest.getRepairDate());
		carRepair.setRepairDescription(createCarRepairRequest.getRepairDescription());
		carRepair.setCar(car);

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRADD);

	}

	@Override
	public Result update(UpdateCarRepairRequest updateCarRepairRequest) {
		
		Car car = new Car();
		car.setCarId(updateCarRepairRequest.getCarId());

		CarRepair carRepair = this.carRepairDao.getById(updateCarRepairRequest.getCarRepairId());
		carRepair.setRepairDate(updateCarRepairRequest.getRepairDate());
		carRepair.setRepairDescription(updateCarRepairRequest.getRepairDescription());
		carRepair.setReturnStatus(updateCarRepairRequest.isReturnStatus());
		carRepair.setReturnDate(updateCarRepairRequest.getReturnDate());
		carRepair.setCar(car);

		this.carRepairDao.save(carRepair);

		return new SuccessResult(Messages.REPAIRUPDATE);
		
	}

	@Override
	public Result delete(DeleteCarRepairRequest deleteCarRepairRequest) {
		CarRepair carRepair = this.carRepairDao.getById(deleteCarRepairRequest.getCarRepairId());
		
		this.carRepairDao.delete(carRepair);
		return new SuccessResult(Messages.REPAIRDELETE);
		
	}

	private Result checkIfCarRented(int carId) {

        if (this.rentalDao.getByCar_CarId(carId).size() != 0) {
            Rental rental = this.rentalDao.getByCar_CarId(carId).get(this.rentalDao.getByCar_CarId(carId).size() - 1);

            if (rental.getReturnDate() == null) {
                return new ErrorResult(Messages.ERROR);
            }
        }
        return new SuccessResult();
    }
}