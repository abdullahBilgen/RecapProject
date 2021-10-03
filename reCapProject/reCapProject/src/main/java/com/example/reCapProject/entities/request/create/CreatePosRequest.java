package com.example.reCapProject.entities.request.create;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePosRequest {
	
	private String cardNumber;
	
	private String cvc;
	
	private Date pullDate;
	
	
	
	

}
