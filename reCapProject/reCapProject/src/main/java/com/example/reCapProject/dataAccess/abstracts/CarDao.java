package com.example.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.dtos.CarDetailDto;


public interface CarDao extends JpaRepository<Car, Integer> {

	@Query("Select new com.example.reCapProject.entities.dtos.CarDetailDto"	
			+ " (c.carName, b.brandName , col.colorName, c.dailyPrice) " 
			+ " From Brand b Inner Join b.cars c"
			+ " Inner Join c.color col")
	
	List<CarDetailDto> getCarWithDetails();
	
	List<Car> getByBrand_BrandName(String brandName);
	
	List<Car> getByColor_ColorName(String colorName);
	
	List<Car> findByCarRepair_ReturnStatus(boolean returnStatus);
	
	List<Car> findByRentals_ReturnStatus(boolean returnStatus);
	
	List<Car>getByCity(String city);

	Car getByCarName(String carName);
	

	@Query ("SELECT c.carFindeks FROM Car c WHERE carId=:carId")
	int getFindeksPointByCar_CarId(int carId);
	
	

}

