package com.example.reCapProject.entities.request.update;

import java.util.Date;

import com.example.reCapProject.entities.request.create.CreateInvoiceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {
	
	private Date rentDate;
	private Date invoiceDate;
	private String invoiceNumber;
	private String invoiceAmount;
	private Long totalRentDay;
	
	private int invoiceId;
	
	private int rentalId;
	
	private int customerId;

}
