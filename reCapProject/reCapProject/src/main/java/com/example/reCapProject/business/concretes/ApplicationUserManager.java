package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.ApplicationUserService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.example.reCapProject.entities.concretes.ApplicationUser;


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
		return new SuccessDataResult<List<ApplicationUser>>(this.applicationUserDao.findAll(), Messages.USERLIST);
	}

}
