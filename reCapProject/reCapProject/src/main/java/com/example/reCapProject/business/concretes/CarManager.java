package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarDao;
import com.example.reCapProject.dataAccess.abstracts.CarImageDao;
import com.example.reCapProject.entities.concretes.Brand;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.dtos.CarDetailDto;
import com.example.reCapProject.entities.request.CreateCarRequest;
import com.example.reCapProject.entities.request.UpdateCarRequest;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	

	@Autowired
	public CarManager(CarDao carDao, CarImageDao carImageDao) {
		super();
		this.carDao = carDao;
	
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(carDao.findAll(),Messages.GETALL);
	}

	@Override
	public DataResult<Car> getById(int carId) {
		return new SuccessDataResult<Car>(this.carDao.getById(carId),Messages.GETID);
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		
		Brand brand = new Brand();
		brand.setBrandId(createCarRequest.getBrandId());
		
		Color color = new Color();
		color.setColorId(createCarRequest.getColorId());
		
		Car car =new Car();
		car.setCarName(createCarRequest.getCarName());
		car.setDailyPrice(createCarRequest.getDailyPrice());
		car.setDescription(createCarRequest.getDescription());
		car.setModelYear(createCarRequest.getModelYear());
		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Brand brand = new Brand();
		brand.setBrandId(updateCarRequest.getBrandId());
		
		Color color = new Color();
		color.setColorId(updateCarRequest.getColorId());
		
		Car car = new Car();
		car.setCarName(updateCarRequest.getCarName());
		car.setDescription(updateCarRequest.getDescription());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setModelYear(updateCarRequest.getModelYear());
		car.setBrand(brand);
		car.setColor(color);
		
		this.carDao.save(car);
		return new SuccessResult(Messages.UPDATE);

	}

	@Override
	public Result delete(Car car) {
		
		this.carDao.delete(car);
		return new SuccessResult(Messages.DELETE);

	}

	@Override
	public DataResult<List<CarDetailDto>> getCarWithDetails() {
		return new SuccessDataResult<List<CarDetailDto>>(this.carDao.getCarWithDetails());
	}

	@Override
	public DataResult<List<Car>> getByBrandName(String brandName) {
		
		return new SuccessDataResult<List<Car>>(this.carDao.getByBrand_BrandName(brandName),Messages.LIST);
	}

	@Override
	public DataResult<List<Car>> getByColorName(String colorName) {
		
		return new SuccessDataResult<List<Car>>(this.carDao.getByColor_ColorName(colorName),Messages.LIST);
	}
}
