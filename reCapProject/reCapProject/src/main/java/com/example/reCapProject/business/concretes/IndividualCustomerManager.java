package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.IndividualCustomerService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.IndividualCustomerDao;
import com.example.reCapProject.entities.concretes.IndividualCustomer;
import com.example.reCapProject.entities.request.create.CreateIndividualCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteIndividualCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateIndividualCustomerRequest;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

	@Autowired
	private IndividualCustomerDao individualCustomerDao;

	public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao) {
		super();
		this.individualCustomerDao = individualCustomerDao;
	}

	@Override
	public Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {

		IndividualCustomer individualCustomer = new IndividualCustomer();

		individualCustomer.setFirstName(createIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(createIndividualCustomerRequest.getLastName());
		individualCustomer.setEmail(createIndividualCustomerRequest.getEmail());
		individualCustomer.setPassword(createIndividualCustomerRequest.getPassword());
		individualCustomer.setIdentityNumber(createIndividualCustomerRequest.getIdentityNumber());
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERADD);

	}

	@Override
	public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		IndividualCustomer individualCustomer = this.individualCustomerDao
				.getByIdentityNumber(updateIndividualCustomerRequest.getIdentityNumber());
		individualCustomer.setUserId(updateIndividualCustomerRequest.getId());

		individualCustomer.setFirstName(updateIndividualCustomerRequest.getFirstName());
		individualCustomer.setLastName(updateIndividualCustomerRequest.getLastName());
		individualCustomer.setEmail(updateIndividualCustomerRequest.getEmail());
		individualCustomer.setPassword(updateIndividualCustomerRequest.getPassword());
		individualCustomer.setIdentityNumber(updateIndividualCustomerRequest.getIdentityNumber());
		this.individualCustomerDao.save(individualCustomer);
		return new SuccessResult(Messages.CUSTOMERUPDATE);
	}

	@Override
	public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		IndividualCustomer customer = new IndividualCustomer();
		customer.setUserId(
				this.individualCustomerDao.getByIdentityNumber(deleteIndividualCustomerRequest.getIdentityNumber()).getUserId());

		this.individualCustomerDao.deleteById(customer.getUserId());
		return new SuccessResult(Messages.CUSTOMERDELETE);
	}

	@Override
	public DataResult<List<IndividualCustomer>> getAll() {
		return new SuccessDataResult<List<IndividualCustomer>>(this.individualCustomerDao.findAll(),
				Messages.CUSTOMERLIST);
	}

}
