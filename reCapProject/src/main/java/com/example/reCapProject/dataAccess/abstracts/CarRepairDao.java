package com.example.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.CarRepair;

public interface CarRepairDao extends JpaRepository<CarRepair, Integer> {
	
	List<CarRepair> getByCar_CarId(int carId);

}
