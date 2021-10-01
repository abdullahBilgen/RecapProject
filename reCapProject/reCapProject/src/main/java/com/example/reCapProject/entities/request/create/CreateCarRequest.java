package com.example.reCapProject.entities.request.create;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	private String carName;
	
	private String currentMileage;
	
	@Min(2000)
	private int modelYear;
	
	@Max(50000)
	private double dailyPrice;
	
	private String city;
	
	@Size(max=100)
	private String description;
	
	@Max(1900)
	@Min(0)
	private int carFindeks;
	
	private int brandId;
	
	private int colorId;

}