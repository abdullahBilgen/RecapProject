package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.RentalService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;

import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreateRentalRequest;
import com.example.reCapProject.entities.request.update.UpdateRentalRequest;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

	RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}

	@PostMapping("/addindividualcustomer")
	public Result addIndividualCustomer(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.addIndividualCustomer(createRentalRequest);

	}

	@PostMapping("/addcorporatecustomer")
	public Result addCorporateCustomer(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.addCorporateCustomer(createRentalRequest);

	}

	@GetMapping("/getall")
	public DataResult<List<Rental>> getAll() {
		return this.rentalService.getAll();
	}

	@PostMapping("/updateindividualcustomer")
	public Result updateIndividualCustomer(@Valid @RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.updateIndividualCustomer(updateRentalRequest);

	}

	@PostMapping("/updatecorporatecustomer")
	public Result updateCorporateCustomer(@Valid @RequestBody  UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.updateCorporateCustomer(updateRentalRequest);

	}

}
