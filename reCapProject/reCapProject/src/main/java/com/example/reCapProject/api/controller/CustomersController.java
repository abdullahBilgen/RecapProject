package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.CustomerService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.request.CreateCustomerRequest;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
	
	CustomerService customerService;

	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Customer>> getAll() {
		return this.customerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.add(createCustomerRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<Customer> getById(int customerId) {
		return this.customerService.getById(customerId);
	}

	@PostMapping("update")
	public Result update(Customer customer) {
		return this.customerService.update(customer);
	}

	@PutMapping("delete")
	public Result delete(Customer customer) {
		return this.customerService.delete(customer);
	}

	

}
