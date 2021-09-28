package com.example.reCapProject.entities.request.create;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {
	
	@NotNull
	private int carId;
	
	@JsonIgnore
	private MultipartFile file;
	
	
	
	

}
