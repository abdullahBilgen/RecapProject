package com.example.reCapProject.entities.request.update;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarImageRequest {
		
	@NotNull
	private int carId;
	
	private String imagePath;
	

}
