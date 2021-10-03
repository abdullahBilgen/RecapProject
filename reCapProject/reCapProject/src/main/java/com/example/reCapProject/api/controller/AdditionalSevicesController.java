package com.example.reCapProject.api.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.AdditionalServiceService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.AdditionalService;
import com.example.reCapProject.entities.concretes.Car;
import com.example.reCapProject.entities.request.create.CreateAdditionalServiceRequest;
import com.example.reCapProject.entities.request.delete.DeleteAdditionalServiceRequest;
import com.example.reCapProject.entities.request.update.UpdateAdditionalServiceRequest;

@RestController
@RequestMapping("/additional_service")
public class AdditionalSevicesController {
	AdditionalServiceService additionalServiceService;

	@Autowired
	public AdditionalSevicesController(AdditionalServiceService additionalServiceService) {
		super();
		this.additionalServiceService = additionalServiceService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		return this.additionalServiceService.add(createAdditionalServiceRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		return this.additionalServiceService.update(updateAdditionalServiceRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		return this.additionalServiceService.delete(deleteAdditionalServiceRequest);
	}

	@GetMapping("/getbyid")
	public DataResult<AdditionalService> getById(int additionalId) {
		return this.additionalServiceService.getById(additionalId);
	}
}
