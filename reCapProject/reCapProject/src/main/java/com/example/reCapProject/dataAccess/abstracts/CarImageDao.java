package com.example.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	
	
	
	List<CarImage> getByCar_CarId(int carId);
	
	CarImage getImagePathByCar_CarId(int carId);
	
	int countCarImageByCar_CarId(int carId);
	

	

	

}
