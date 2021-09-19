package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.CreateRentalRequest;

public interface RentalService {
	
    DataResult<List<Rental >> getAll();
	
	DataResult<Rental> getById(int rentalId);
	
	Result add(CreateRentalRequest createRentalRequest);
	
	Result update(Rental rental);
	
	Result delete(Rental rental);


}
