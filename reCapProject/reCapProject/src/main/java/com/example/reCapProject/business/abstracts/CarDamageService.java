package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarDamage;
import com.example.reCapProject.entities.request.create.CreateCarDamageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarDamagesRequest;
import com.example.reCapProject.entities.request.update.UpdateCarDamageRequest;

public interface CarDamageService {
	
	DataResult<List<CarDamage>> getAll();
	
	DataResult<List<CarDamage>> getByCarId(int carId);
	
	Result add(CreateCarDamageRequest createCarDamageRequest );
	
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	
	Result delete(DeleteCarDamagesRequest deleteCarDamagesRequest);

}