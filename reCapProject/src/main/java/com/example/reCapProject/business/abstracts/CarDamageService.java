package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarDamage;
import com.example.reCapProject.entities.request.create.CreateCarDamageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarDamageRequest;
import com.example.reCapProject.entities.request.update.UpdateCarDamageRequest;

public interface CarDamageService {

	Result add(CreateCarDamageRequest createCarDamageRequest);
	
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	
	Result delete(DeleteCarDamageRequest deleteCarDamageRequest);
	
	DataResult<List<CarDamage>> getAll();
	
	DataResult<List<CarDamage>> getByCarId(int carId);
}
