package com.example.reCapProject.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
import com.example.reCapProject.entities.request.create.CreateCarImageRequest;
import com.example.reCapProject.entities.request.delete.DeleteCarImageRequest;
import com.example.reCapProject.entities.request.update.UpdateCarImageRequest;

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
	public Result add(CreateCarImageRequest createCarImageRequest, MultipartFile file) throws IOException {

		var result = BusinessRules.run(checkIfCarImageOverRun(createCarImageRequest.getCarId(), 5));

		if (result != null) {
			return result;
		}
		
		Car car = new Car();
		car.setCarId(createCarImageRequest.getCarId());

		LocalDate date = LocalDate.now();
		// https://gunceljava.blogspot.com/2016/08/uuid-snf.html
		String imagePath = UUID.randomUUID().toString();

		File imageFile = new File("C:\\Users\\abdullah.bilgen\\Desktop\\carimages\\" + imagePath + ".jpg");

		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(file.getBytes());
		outputImage.close();

		CarImage carImage = new CarImage();
		carImage.setCar(car);
		carImage.setDate(date);
		carImage.setImagePath(imagePath);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.ADD);
	}
	// DEFAULT RESİM EKLEME
		@Override
		public DataResult<List<CarImage>> getImagesWıthCarId(int carId) {
			if (!checkImageIsEmpty(carId).isSuccess()) {
				File defaultImagePath = new File("C:\\Users\\abdullah.bilgen\\RECAP\\defaultimages\\default.jpg");
				System.out.println(defaultImagePath);
				return new SuccessDataResult<List<CarImage>>(Messages.CARIMAGEDEFAULT);
			}
			return new SuccessDataResult<List<CarImage>>(this.carImageDao.getByCar_CarId(carId), Messages.CARIMAGELIST);
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
		return new SuccessResult(Messages.CARIMAGEUPDATE);
	}

	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		Car car = new Car();
		car.setCarId(deleteCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setImageId(deleteCarImageRequest.getCarId());
		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CARIMAGEDELETE);
	}
	
	// EN FAZLA 5 RESİM EKLENEBİLİR.
	public Result checkIfCarImageOverRun(int carId, int limit) {
		if (this.carImageDao.getByCar_CarId(carId).size() >= limit) {
			return new ErrorResult(Messages.CARIMAGEERROR);
		}

		return new SuccessResult(Messages.CARIMAGESUCCESS);
	}

	// CARID İÇERİSİNDE FOTOĞRAF KONTROLÜ
	public Result checkImageIsEmpty(int carId) {
		if (this.carImageDao.getImagePathByCar_CarId(carId) == null) {
			return new ErrorResult(Messages.CARIMAGEERROR);
		}
		return new SuccessResult(Messages.CARIMAGESUCCESS);
	}
}
