package com.example.reCapProject.entities.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
	

	private int creditId;
	
	private int rentalId;
	
	private int paymentId;


}
