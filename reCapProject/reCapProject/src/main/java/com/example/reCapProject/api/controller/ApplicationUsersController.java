package com.example.reCapProject.api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.reCapProject.business.abstracts.ApplicationUserService;
import com.example.reCapProject.core.entities.concretes.User;
import com.example.reCapProject.core.utilities.result.DataResult;


@RestController
@RequestMapping("api/users")
public class ApplicationUsersController {
	
	ApplicationUserService userService;

	public ApplicationUsersController(ApplicationUserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
}
