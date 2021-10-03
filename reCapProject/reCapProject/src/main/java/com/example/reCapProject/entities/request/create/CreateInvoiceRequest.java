package com.example.reCapProject.entities.request.create;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

	@JsonIgnore
	private Date rentDate;
	private Date returnDate;
	
	private Date invoiceDate;
	private String invoiceNumber;
	private double invoiceAmount;

	@JsonIgnore
	private Long totalRentDay;

	private int rentalId;

	private int customerId;

}
