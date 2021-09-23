package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.ApplicationUserService;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.entities.concretes.ApplicationUser;
import com.example.reCapProject.entities.dtos.UserLoginDto;
import com.example.reCapProject.entities.dtos.UserRegisterDto;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	ApplicationUserService applicationUserService;

	@Autowired
	public UserController(ApplicationUserService applicationUserService) {
		super();
		this.applicationUserService = applicationUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.applicationUserService.getAll();
	}
	
	@PostMapping("/logincontrol")
	public ResponseEntity<?>addUser(@Valid @RequestBody UserLoginDto userLoginDto) {
		return ResponseEntity.ok(this.applicationUserService.loginControl(userLoginDto));
	}
	
	@PostMapping("/registercontrol")
	public ResponseEntity<?>addUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
		return ResponseEntity.ok(this.applicationUserService.registerControl(userRegisterDto));
	}
}
