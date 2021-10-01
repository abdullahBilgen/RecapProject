package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.CarRepairService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarRepair;
import com.example.reCapProject.entities.request.create.CreateCarRepairRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarRepairRequest;
import com.example.reCapProject.entities.request.update.UpdateCarRepairRequest;

@RestController
@RequestMapping("api/car_repairs")
public class CarRepairController {
	
	CarRepairService carRepairService;

	@Autowired
	public CarRepairController(CarRepairService carRepairService) {
		
		this.carRepairService = carRepairService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarRepair>> getAll() {
		return this.carRepairService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<CarRepair> getById(int carRepairId) {
		return this.carRepairService.getById(carRepairId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarRepairRequest createCarRepairRequest) {
		return this.carRepairService.add(createCarRepairRequest);
	}
	
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCarRepairRequest updateCarRepairRequest) {
		return this.carRepairService.update(updateCarRepairRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarRepairRequest deleteCarRepairRequest) {
		return this.carRepairService.delete(deleteCarRepairRequest);
	}
}