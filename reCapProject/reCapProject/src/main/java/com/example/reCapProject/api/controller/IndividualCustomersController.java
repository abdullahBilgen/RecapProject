package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.IndividualCustomerService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CorporateCustomer;
import com.example.reCapProject.entities.concretes.IndividualCustomer;
import com.example.reCapProject.entities.request.create.CreateCorporateCustomerRequest;
import com.example.reCapProject.entities.request.create.CreateIndividualCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteCorporateCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteIndividualCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateCorporateCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateIndividualCustomerRequest;

@RestController
@RequestMapping("/individualcustomers")
public class IndividualCustomersController {

	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<IndividualCustomer>> getAll() {
		return this.individualCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		return this.individualCustomerService.add(createIndividualCustomerRequest);
	}

	@PostMapping("update")
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		return this.individualCustomerService.update(updateIndividualCustomerRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}


}
