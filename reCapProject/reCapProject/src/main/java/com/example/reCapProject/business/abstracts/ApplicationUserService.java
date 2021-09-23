package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.ApplicationUser;
import com.example.reCapProject.entities.dtos.UserLoginDto;
import com.example.reCapProject.entities.dtos.UserRegisterDto;
import com.example.reCapProject.entities.request.create.CreateApplicationUserRequest;

public interface ApplicationUserService {

    DataResult<List<ApplicationUser >> getAll();
	
	DataResult<ApplicationUser > getById(int userId);
	
	Result add(CreateApplicationUserRequest createUserRequest);
	
	Result update(ApplicationUser applicationUser);
	
	Result delete(ApplicationUser applicationUser);
	
	Result registerControl(UserRegisterDto userRegisterDto);
	
	Result loginControl(UserLoginDto userLoginDto);
}
