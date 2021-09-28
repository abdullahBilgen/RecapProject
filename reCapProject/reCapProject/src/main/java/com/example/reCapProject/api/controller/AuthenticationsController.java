package com.example.reCapProject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.AuthenticationService;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.request.create.CreateLoginRequest;

@RestController
@RequestMapping("/authentication")
public class AuthenticationsController {
	
	AuthenticationService authenticationService;
	
	@Autowired
	public AuthenticationsController(AuthenticationService authenticationService) {
		this.authenticationService=authenticationService;	
	}
	
	@PostMapping("/logIn")
	public Result logIn(CreateLoginRequest createLoginRequest) {
		return this.authenticationService.logIn(createLoginRequest);
		
	}

}
