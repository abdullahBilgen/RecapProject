package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarDamageService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarDamageDao;
import com.example.reCapProject.dataAccess.abstracts.CarDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarDamage;
import com.example.reCapProject.entities.request.create.CreateCarDamageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarDamageRequest;
import com.example.reCapProject.entities.request.update.UpdateCarDamageRequest;

@Service
public class CarDamageManager implements CarDamageService {

	CarDamageDao carDamageDao;
	CarDao carDao;
	
	@Autowired
	public CarDamageManager(CarDamageDao carDamageDao, CarDao carDao) {
		super();
		this.carDamageDao = carDamageDao;
		this.carDao = carDao;
	}

	@Override
	public Result add(CreateCarDamageRequest createCarDamageRequest) {
		
		Car car = this.carDao.getById(createCarDamageRequest.getCarId());
		
		CarDamage carDamage = new CarDamage();
		carDamage.setDamageDescription(createCarDamageRequest.getInformation());
		
		carDamage.setCar(car);
		
		this.carDamageDao.save(carDamage);
		
		return new SuccessResult(Messages.CARDAMAGEADD);
	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
	
		Car car = this.carDao.getById(updateCarDamageRequest.getCarId());
		
		CarDamage carDamage = this.carDamageDao.getById(updateCarDamageRequest.getCarDamagesId());
		carDamage.setDamageDescription(updateCarDamageRequest.getInformation());
		
		carDamage.setCar(car);
		
		this.carDamageDao.save(carDamage);
		
		return new SuccessResult(Messages.CARDAMAGEUPDATE);
	}

	@Override
	public Result delete(DeleteCarDamageRequest deleteCarDamageRequest) {

		CarDamage carDamage = this.carDamageDao.getById(deleteCarDamageRequest.getCarDamagesId());
		
		this.carDamageDao.delete(carDamage);
		return new SuccessResult(Messages.CARDAMAGEDELETE);
	}

	@Override
	public DataResult<List<CarDamage>> getAll() {
		
		return new SuccessDataResult<List<CarDamage>>(this.carDamageDao.findAll());
	}

	@Override
	public DataResult<List<CarDamage>> getByCarId(int carId) {
		
		List<CarDamage> carsDamages = this.carDamageDao.getByCar_CarId(carId);
		
		return new SuccessDataResult<List<CarDamage>>(carsDamages,Messages.CARDAMAGELIST);
	}

}
