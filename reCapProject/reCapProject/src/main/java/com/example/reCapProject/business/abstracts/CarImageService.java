package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarImage;
import com.example.reCapProject.entities.request.CreateCarImageRequest;
import com.example.reCapProject.entities.request.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.UpdateCarImageRequest;

public interface CarImageService {

	DataResult<List<CarImage>> getAll();
	
	DataResult <List<CarImage>>getByCar_CarId (int carId);

	DataResult<CarImage> getById(int imageId);

	Result add(CreateCarImageRequest createCarImageRequest);

	Result update(UpdateCarImageRequest updateCarImageRequest);

	Result delete(DeleteCarImageRequest deleteCarImageRequest);

}
