package com.example.reCapProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.AuthenticationService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.example.reCapProject.entities.request.create.CreateLoginRequest;
@Service
public class AuthenticationManager implements AuthenticationService {

	ApplicationUserDao applicationUserDao;

	@Autowired
	public AuthenticationManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public Result logIn(CreateLoginRequest createLoginRequest) {
		var result = BusinessRules.run(checkEmailAndPassword(createLoginRequest));

		if (result != null) {
			return result;
		}

		return new SuccessResult(Messages.LOGINSUCCESS);
	}

	private Result checkEmailAndPassword(CreateLoginRequest createLoginRequest) {
		if (!this.applicationUserDao.existsByEmail(createLoginRequest.getEmail())) {

			return new ErrorResult(Messages.LOGINEMAILERROR);
		}
		if (!this.applicationUserDao.getByEmail(createLoginRequest.getEmail()).getPassword().equals(createLoginRequest.getPassword())) {

			return new ErrorResult (Messages.LOGINPASSWORDERROR);
		}

		return new SuccessResult();
	}
}
