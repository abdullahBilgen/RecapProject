package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.IndividualCustomer;
import com.example.reCapProject.entities.request.create.CreateIndividualCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteIndividualCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateIndividualCustomerRequest;

public interface IndividualCustomerService {
	
	
	Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);

	DataResult<List<IndividualCustomer>> getAll();
}
