package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.request.CreateCustomerRequest;

public interface CustomerService {
	
    DataResult<List<Customer>> getAll();
	
	DataResult<Customer> getById(int customerId);
	
	Result add(CreateCustomerRequest createCustomerRequest);
	
	Result update(Customer customer);
	
	Result delete(Customer customer);

}
