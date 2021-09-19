package com.example.reCapProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.reCapProject.business.abstracts.CarImageService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarImage;

import com.example.reCapProject.entities.request.CreateCarImageRequest;

import com.example.reCapProject.entities.request.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.UpdateCarImageRequest;

@RestController
@RequestMapping("api/car_images")
public class CarImageController {

	 CarImageService carImageService;

	@Autowired
	public CarImageController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	@GetMapping("/getall")
	public DataResult<List<CarImage>> getAll() {
		return this.carImageService.getAll();
	}

	@GetMapping("/getbycarid")
	public DataResult<List<CarImage>> getByCarId(int carId) {
		return this.carImageService.getByCar_CarId(carId);
	}

	@GetMapping("/getbyid")
	public DataResult<CarImage> getById(int imageId) {
		return this.carImageService.getById(imageId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateCarImageRequest createCarImageRequest) {
		return this.carImageService.add(createCarImageRequest);
	}

	@PostMapping("/update")
	public Result update(UpdateCarImageRequest updateCarImageRequest) {
		return this.carImageService.update(updateCarImageRequest);
	}

	@PutMapping("/delete")
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}

}
