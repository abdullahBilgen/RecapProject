package com.example.reCapProject.entities.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageRequest {
	
	private int carDamagesId;
	
	private int carId;
	
	private String damageDescription;

}