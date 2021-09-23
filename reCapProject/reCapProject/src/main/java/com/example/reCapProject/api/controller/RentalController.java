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

@RestController
@RequestMapping("api/rentals")
public class RentalController {
	
	RentalService rentalService;

	@Autowired
	public RentalController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Rental>> getAll() {
		return this.rentalService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.add(createRentalRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<Rental> getById(int rentalId) {
		return this.rentalService.getById(rentalId);
	}
}
