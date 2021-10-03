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

import com.example.reCapProject.business.abstracts.CarDamageService;
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

@RestController
@RequestMapping("api/car_damages")
public class CarDamageController {
	
	CarDamageService carDamageService;
	
	@Autowired
	public CarDamageController(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CarDamage>> getAll() {
		return this.carDamageService.getAll();
	}

	@GetMapping("/getbycarid")
	public DataResult<List<CarDamage>> getByCarId(int carId) {
		return this.carDamageService.getByCarId(carId);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCarDamageRequest createCarDamageRequest) {
		return this.carDamageService.add(createCarDamageRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateCarDamageRequest updateCarDamageRequest) {
		return this.carDamageService.update(updateCarDamageRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteCarDamagesRequest deleteCarDamageRequest) {
		return this.carDamageService.delete(deleteCarDamageRequest);
	}
	
	
	
	

}
