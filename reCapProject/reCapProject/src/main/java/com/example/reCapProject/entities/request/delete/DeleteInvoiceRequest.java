package com.example.reCapProject.entities.request.delete;

import java.util.Date;

import com.example.reCapProject.entities.request.create.CreateInvoiceRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInvoiceRequest {
	
	private int invoiceId;

}
