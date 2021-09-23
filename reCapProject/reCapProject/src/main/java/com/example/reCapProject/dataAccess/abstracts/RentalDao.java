package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reCapProject.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer> {

	boolean existsByReturnRentControlIsFalse();	
}
