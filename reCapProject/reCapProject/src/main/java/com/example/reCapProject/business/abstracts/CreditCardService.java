package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CreditCard;
import com.example.reCapProject.entities.request.create.CreateCreditCardRequest;
import com.example.reCapProject.entities.request.delete.DeleteCreditCardRequest;
import com.example.reCapProject.entities.request.update.UpdateCreditCardRequest;



public interface CreditCardService {
	

	DataResult<List<CreditCard>> getAll();
	
	DataResult <CreditCard> getById(int customerId);
	

	Result add(CreateCreditCardRequest createCreditCardRequest);

	Result delete(DeleteCreditCardRequest deleteCreditCardRequest);
	
	Result update(UpdateCreditCardRequest updateCreditCardRequest);
	

	

	

	
}
