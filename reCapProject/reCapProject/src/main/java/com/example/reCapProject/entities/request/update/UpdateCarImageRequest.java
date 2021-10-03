package com.example.reCapProject.entities.request.update;





import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarImageRequest {
	
	private int imageId;
	@NotNull
	private int carId;
	
	private String imageName;
	
	@JsonIgnore
	private MultipartFile file;
	
	


}
