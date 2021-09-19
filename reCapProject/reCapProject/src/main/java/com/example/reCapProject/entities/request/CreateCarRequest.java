package com.example.reCapProject.entities.request;

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
	
	@Min(2000)
	private String modelYear;
	
	@Max(50000)
	private double dailyPrice;
	
	@Size(max=100)
	private String description;

	
	private int brandId;
	private int colorId;

}
