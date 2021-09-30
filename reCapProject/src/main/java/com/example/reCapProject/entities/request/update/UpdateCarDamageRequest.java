package com.example.reCapProject.entities.request.update;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageRequest {
	
	@NotNull
	private int carDamagesId;
	
	@NotNull
	private int carId;
	
	@NotNull
	private String information;

}
