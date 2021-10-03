package com.example.reCapProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.ApplicationUserService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.entities.concretes.ApplicationUser;

@RestController
@RequestMapping("/api/users")
public class ApplicationUsersController {
	
	@Autowired
	private ApplicationUserService applicationUserService;
	
	
	public ApplicationUsersController(ApplicationUserService applicationUserService) {
		
		this.applicationUserService=applicationUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.applicationUserService.getAll();
		
	}

}
