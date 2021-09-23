package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.dtos.CarDetailDto;
import com.example.reCapProject.entities.request.create.CreateCarRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarRequest;
import com.example.reCapProject.entities.request.update.UpdateCarRequest;

public interface CarService  {
	
	DataResult<List<Car>> getAll();
	
	DataResult<Car> getById(int carId);
	
	DataResult<List<CarDetailDto>> getCarWithDetails();

	DataResult<List<Car>> getByBrandName(String brandName);
	
	DataResult<List<Car>> getByColorName(String colorName);
	
	Result add(CreateCarRequest createCarRequest);
	
	Result update(UpdateCarRequest updateCarRequest);
	
	Result delete(DeleteCarRequest deleteCarRequest);
}
