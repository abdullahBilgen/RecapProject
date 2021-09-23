package com.example.reCapProject.entities.request.delete;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRentalRequest {
	
	@NotNull
	@NotBlank
	private Date rentDate;
	
	private Date returnDate;
	
	@NotNull
	private int carId;
	
	private int customerId;
	
	private boolean rentStatus;
}
