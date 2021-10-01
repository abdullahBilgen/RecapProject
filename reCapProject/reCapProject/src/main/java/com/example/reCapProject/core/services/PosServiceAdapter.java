package com.example.reCapProject.core.services;

import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CreditCardValidatorService;
import com.example.reCapProject.entities.request.create.CreatePosRequest;
@Service
public class PosServiceAdapter implements CreditCardValidatorService {
	
	@Override
	public boolean isValid(CreatePosRequest createPosRequest) {
		
		PosService posService = new PosService();
		
		return posService.posServiceVerification(createPosRequest.getCvc(), createPosRequest.getCardNumber(),createPosRequest.getPullDate());
	    
	}
}