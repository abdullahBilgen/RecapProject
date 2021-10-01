package com.example.reCapProject.entities.request.update;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

	private String pickUpCity;

	private String deliveryCity;
	
	private String startingMileage;
	
	private String endMileage;
	
	@NotNull
	private int rentalId;
	
	private Date rentDate;

	private Date returnDate;

	@NotNull
	private int carId;

	private int customerId;

	private boolean returnStatus;

}