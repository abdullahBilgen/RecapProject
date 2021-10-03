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

import com.example.reCapProject.business.abstracts.CorporateCustomerService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CorporateCustomer;

import com.example.reCapProject.entities.request.create.CreateCorporateCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteCorporateCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateCorporateCustomerRequest;

@RestController
@RequestMapping("/corporatecustomers")
public class CorporateCustomersController {
	
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		this.corporateCustomerService=corporateCustomerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CorporateCustomer>> getAll() {
		return this.corporateCustomerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		return this.corporateCustomerService.add(createCorporateCustomerRequest);
	}

	@PostMapping("update")
	public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		return this.corporateCustomerService.update(updateCorporateCustomerRequest);
	}

	@PutMapping("delete")
	public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
		return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);
	}

}
