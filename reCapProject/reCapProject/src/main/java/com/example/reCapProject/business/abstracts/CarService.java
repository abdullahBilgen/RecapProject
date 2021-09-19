package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.dtos.CarDetailDto;
import com.example.reCapProject.entities.request.CreateCarRequest;

public interface CarService  {
	
	
	DataResult<List<Car>> getAll();
	
	DataResult<Car> getById(int carId);
	
	DataResult<List<CarDetailDto>> getCarWithDetails();
	
	Result add(CreateCarRequest createCarRequest);
	
	Result update(Car car);
	
	Result delete(Car car);
	
	



}
