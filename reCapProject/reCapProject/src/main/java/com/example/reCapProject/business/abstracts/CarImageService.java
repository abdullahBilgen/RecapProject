package com.example.reCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CarImage;
import com.example.reCapProject.entities.request.create.CreateCarImageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.update.UpdateCarImageRequest;

public interface CarImageService {

	DataResult<List<CarImage>> getAll();
	
	DataResult <List<CarImage>>getImagesWıthCarId (int carId);
	

	Result add(CreateCarImageRequest createCarImageRequest)throws IOException;

	Result update(UpdateCarImageRequest updateCarImageRequest);

	Result delete(DeleteCarImageRequest deleteCarImageRequest);

	

	

}
