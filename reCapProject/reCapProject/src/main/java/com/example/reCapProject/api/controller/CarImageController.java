package com.example.reCapProject.api.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.reCapProject.business.abstracts.CarImageService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarImage;
import com.example.reCapProject.entities.request.create.CreateCarImageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.update.UpdateCarImageRequest;

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
		return this.carImageService.getImagesWıthCarId(carId);
	}


	@PostMapping("/add")
	public Result add(@Valid @RequestParam ("carId") int carId,MultipartFile file) throws IOException {
		CreateCarImageRequest createCarImageRequest = new CreateCarImageRequest();
		createCarImageRequest.setCarId(carId);
		createCarImageRequest.setFile(file);
			
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
