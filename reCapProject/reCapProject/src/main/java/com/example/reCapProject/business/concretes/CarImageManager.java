package com.example.reCapProject.business.concretes;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CarImageService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CarImageDao;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.concretes.CarImage;
import com.example.reCapProject.entities.request.CreateCarImageRequest;
import com.example.reCapProject.entities.request.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.UpdateCarImageRequest;

@Service
public class CarImageManager implements CarImageService {

	CarImageDao carImageDao;

	@Autowired
	public CarImageManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}

	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<List<CarImage>>(carImageDao.findAll(), Messages.GETALL);
	}

	@Override
	public DataResult<CarImage> getById(int imageId) {
		return new SuccessDataResult<CarImage>(this.carImageDao.getById(imageId), Messages.GETID);
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) {

		var result = BusinessRules.run(checkIfCarImageOverRun(createCarImageRequest.getCarId(), 5));
		
		if (result != null) {
			return result;
		}

		// https://gunceljava.blogspot.com/2016/08/uuid-snf.html
		String imagePath = UUID.randomUUID().toString();
		LocalDate date = LocalDate.now();

		Car car = new Car();
		car.setCarId(createCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setCar(car);
		carImage.setDate(date);
		carImage.setImagePath("carImages/" + imagePath + ".jpg");

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.ADD);

	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) {

		Car car = new Car();
		car.setCarId(updateCarImageRequest.getCarId());

		String imagePath = UUID.randomUUID().toString();

		CarImage carImage = new CarImage();
		carImage.setImageId(updateCarImageRequest.getCarId());
		carImage.setImagePath("carImages/" + imagePath + ".jpg");
		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.UPDATE);

	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		Car car = new Car();
		car.setCarId(deleteCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setImageId(deleteCarImageRequest.getCarId());
		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public DataResult<List<CarImage>> getByCar_CarId(int carId) {

		return new SuccessDataResult<List<CarImage>>(this.carImageDao.getByCar_CarId(carId), Messages.GETID);

	}

	public Result checkIfCarImageOverRun(int carId, int limit) {
		if (this.carImageDao.getByCar_CarId(carId).size() >= limit) {
			return new ErrorResult(Messages.ERROR);
		}

		return new SuccessResult(Messages.SUCCESS);
	}
}
