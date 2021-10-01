package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarDamageService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarDamageDao;
import com.example.reCapProject.dataAccess.abstracts.CarDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarDamage;
import com.example.reCapProject.entities.request.create.CreateCarDamageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarDamagesRequest;
import com.example.reCapProject.entities.request.update.UpdateCarDamageRequest;

@Service
public class CarDamageManager implements CarDamageService{
	
	private CarDamageDao carDamageDao;
	private CarDao carDao;
	
	@Autowired
	public CarDamageManager(CarDamageDao carDamageDao,CarDao carDao) {
		super();
		this.carDamageDao = carDamageDao;
		this.carDao=carDao;
	}

	@Override
	public DataResult<List<CarDamage>> getAll() {
		return new SuccessDataResult<List<CarDamage>>(this.carDamageDao.findAll());
	}

	@Override
	public DataResult<List<CarDamage>> getByCarId(int carId) {
		return new SuccessDataResult<List<CarDamage>>(this.carDamageDao.getByCar_CarId(carId));
	}

	@Override
	public Result add(CreateCarDamageRequest createCarDamageRequest) {
		Car car = this.carDao.getById(createCarDamageRequest.getCarId());
		
		CarDamage carDamage= new CarDamage();
		carDamage.setDamageDescription(createCarDamageRequest.getDamageDescription());
		
		carDamage.setCar(car);
		this.carDamageDao.save(carDamage);
		
		return new SuccessResult();
		
	}

	@Override
	public Result update(UpdateCarDamageRequest updateCarDamageRequest) {
		Car car = this.carDao.getById(updateCarDamageRequest.getCarId());
		
		CarDamage carDamage= new CarDamage();
		carDamage.setDamageDescription(updateCarDamageRequest.getDamageDescription());
		
		carDamage.setCar(car);
		this.carDamageDao.save(carDamage);
		
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCarDamagesRequest deleteCarDamagesRequest) {
		CarDamage carDamage= this.carDamageDao.getById(deleteCarDamagesRequest.getCarDamagesId());
		
		this.carDamageDao.delete(carDamage);
		
		return new SuccessResult();
	}
}