package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.ApplicationUserService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.entities.concretes.User;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.example.reCapProject.entities.concretes.ApplicationUser;
import com.example.reCapProject.entities.dtos.UserLoginDto;
import com.example.reCapProject.entities.dtos.UserRegisterDto;
import com.example.reCapProject.entities.request.create.CreateApplicationUserRequest;

@Service
public class ApplicationUserManager implements ApplicationUserService {


	private ApplicationUserDao applicationUserDao;

	@Autowired
	public ApplicationUserManager(ApplicationUserDao applicationUserDao) {
		super();
		
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		return new SuccessDataResult<List<ApplicationUser>>(this.applicationUserDao.findAll(), Messages.GETALL);
	}

	@Override
	public DataResult<ApplicationUser > getById(int userId) {
		return new SuccessDataResult<ApplicationUser>(this.applicationUserDao.getById(userId), Messages.GETID);
	}

	@Override
	public Result add(CreateApplicationUserRequest createApplicationUserRequest) {

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName(createApplicationUserRequest.getFirstName());
		applicationUser.setLastName(createApplicationUserRequest.getLastName());
		applicationUser.setEMail(createApplicationUserRequest.getEMail());
		applicationUser.setPassword(createApplicationUserRequest.getPassword());

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult(Messages.ADD);
	}

	@Override
	public Result update(ApplicationUser applicationUser) {
		this.applicationUserDao.save(applicationUser);
		return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(ApplicationUser applicationUser) {
		this.applicationUserDao.delete(applicationUser);
		return new SuccessResult(Messages.DELETE);
	}

	@Override
	public Result registerControl(UserRegisterDto userRegisterDto) {

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setEMail(userRegisterDto.getEmail());
		applicationUser.setPassword(userRegisterDto.getPassword());
		applicationUser.setFirstName(userRegisterDto.getFirstName());
		applicationUser.setLastName(userRegisterDto.getLastName());

		var result = BusinessRules.run(checkControlRegisterLogin(applicationUser));

		if (result != null) {
			return result;
		}

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult();
	}

	@Override
	public Result loginControl(UserLoginDto userLoginDto) {

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setEMail(userLoginDto.getEmail());
		applicationUser.setPassword(userLoginDto.getPassword());

		var result = BusinessRules.run(checkControlUserLogin(applicationUser));

		if (result != null) {
			return result;
		}

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult();
	}

	public Result checkControlUserLogin(ApplicationUser applicationUser) {
		for (User users : this.applicationUserDao.findAll()) {

			if (users.getEMail().equals(applicationUser.getEMail())
					&& users.getPassword().equals(applicationUser.getPassword())) {

				return new SuccessResult();
			}
		}
		return new ErrorResult(Messages.ERROR);
	}
	
	public Result checkControlRegisterLogin(ApplicationUser applicationUser) {
		for (User users : this.applicationUserDao.findAll()) {

			if (users.getEMail().equals(applicationUser.getEMail())
					&& users.getPassword().equals(applicationUser.getPassword())
					&& users.getFirstName().equals(applicationUser.getFirstName())
					&& users.getLastName().equals(applicationUser.getLastName())) {

				return new SuccessResult();
			}
		}
		return new ErrorResult(Messages.ERROR);
	}
}
