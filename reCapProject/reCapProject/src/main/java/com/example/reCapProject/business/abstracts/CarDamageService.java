package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarDamage;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.request.create.CreateCarDamageRequest;
import com.example.reCapProject.entities.request.create.CreateColorRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarDamagesRequest;
import com.example.reCapProject.entities.request.delete.DeleteColorRequest;
import com.example.reCapProject.entities.request.update.UpdateCarDamageRequest;
import com.example.reCapProject.entities.request.update.UpdateColorRequest;

public interface CarDamageService {
	
	DataResult<List<CarDamage>> getAll();
	
	DataResult<List<CarDamage>> getByCarId(int carId);
	
	Result add(CreateCarDamageRequest createCarDamageRequest );
	
	Result update(UpdateCarDamageRequest updateCarDamageRequest);
	
	Result delete(DeleteCarDamagesRequest deleteCarDamagesRequest);
	
	

}
