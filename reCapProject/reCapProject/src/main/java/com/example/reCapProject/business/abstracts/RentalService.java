package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreateRentalRequest;
import com.example.reCapProject.entities.request.delete.DeleteRentalRequest;
import com.example.reCapProject.entities.request.update.UpdateRentalRequest;

public interface RentalService {
	
    DataResult<List<Rental >> getAll();
	
	DataResult<Rental> getById(int rentalId);
	
	Result add(CreateRentalRequest createRentalRequest);
	
	Result update(UpdateRentalRequest updateRentalRequest);
	
	Result delete(DeleteRentalRequest deleteRentalRequest);
}
