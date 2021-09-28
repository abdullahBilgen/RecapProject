package com.example.reCapProject.business.abstracts;

import java.util.List;



import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreateRentalRequest;

import com.example.reCapProject.entities.request.update.UpdateRentalRequest;

public interface RentalService {
	
    DataResult<List<Rental >> getAll();
	
	DataResult<Rental> getById(int rentalId);
	
	Result addCorporateCustomer(CreateRentalRequest createRentalRequest);
	Result addIndividualCustomer(CreateRentalRequest createRentalRequest);
	
	Result updateCorporateCustomer(UpdateRentalRequest updateRentalRequest);
	Result updateIndividualCustomer(UpdateRentalRequest updateRentalRequest);
	
	


	
	
	
	
	

	


}
