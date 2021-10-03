package com.example.reCapProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;

import com.example.reCapProject.entities.concretes.CarRepair;
import com.example.reCapProject.entities.request.create.CreateCarRepairRequest;

import com.example.reCapProject.entities.request.delete.DeleteCarRepairRequest;

import com.example.reCapProject.entities.request.update.UpdateCarRepairRequest;


	
	public interface CarRepairService {
	
	DataResult<CarRepair> getById(int carRepairId);
	
	DataResult<List<CarRepair>> getAll();
	
	Result add(CreateCarRepairRequest createCarRepairRequest);
	
	Result update(UpdateCarRepairRequest updateCarRepairRequest);

	Result delete(DeleteCarRepairRequest deleteCarRepairRequest);
	

}
