package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.entities.concretes.User;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.request.CreateApplicationUserRequest;

public interface UserService {


    DataResult<List<User>> getAll();
	
	DataResult<User> getById(int userId);
	
	Result add(CreateApplicationUserRequest createUserRequest);
	
	Result update(User user);
	
	Result delete(User user);

}
