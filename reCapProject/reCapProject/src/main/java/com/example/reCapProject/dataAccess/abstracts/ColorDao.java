package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.Color;

public interface ColorDao extends JpaRepository<Color,Integer> {

	Color getByColorName(String colorName);
	
}
