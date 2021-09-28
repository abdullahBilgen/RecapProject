package com.example.reCapProject.entities.request.create;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRepairRequest {
	
	@NotNull
	private int carId;
	
	@NotNull
	private String repairDescription;
	
	@NotNull
	private Date repairDate;
	


}
