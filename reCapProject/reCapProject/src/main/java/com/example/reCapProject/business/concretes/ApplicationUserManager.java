package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.ApplicationUserService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.entities.concretes.User;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.example.reCapProject.entities.concretes.ApplicationUser;
import com.example.reCapProject.entities.request.CreateApplicationUserRequest;

@Service
public class ApplicationUserManager implements ApplicationUserService {

	private ApplicationUserDao userDao;

	@Autowired
	public ApplicationUserManager(ApplicationUserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>     
		(this.userDao.findAll(), Messages.GETALL);
	}

	@Override
	public DataResult<User> getById(int userId) {
		return new SuccessDataResult<User> 
		(this.userDao.getById(userId),Messages.GETID); 
	}

	@Override
	public Result add(CreateApplicationUserRequest createApplicationUserRequest) {
		
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName(createApplicationUserRequest.getFirstName());
		applicationUser.setLastName(createApplicationUserRequest.getLastName());
		applicationUser.setEMail(createApplicationUserRequest.getEMail());
		applicationUser.setPassword(createApplicationUserRequest.getPassword());
		
		
		this.userDao.save(applicationUser); 
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(User user) {
		this.userDao.save(user); 
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user); 
		return new SuccessResult(Messages.DELETE);
	}
}
