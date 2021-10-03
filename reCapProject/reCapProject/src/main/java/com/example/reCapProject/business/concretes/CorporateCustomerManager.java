package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CorporateCustomerService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CorporateCustomerDao;
import com.example.reCapProject.dataAccess.abstracts.CustomerDao;
import com.example.reCapProject.entities.concretes.CorporateCustomer;
import com.example.reCapProject.entities.request.create.CreateCorporateCustomerRequest;
import com.example.reCapProject.entities.request.delete.DeleteCorporateCustomerRequest;
import com.example.reCapProject.entities.request.update.UpdateCorporateCustomerRequest;
@Service
public class CorporateCustomerManager implements CorporateCustomerService {
	
	private CustomerDao customerDao;
	private CorporateCustomerDao corporateCustomerDao;
	
	
	@Autowired
	public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao,CustomerDao customerDao) {
		super();
		this.corporateCustomerDao = corporateCustomerDao;
		this.customerDao=customerDao;
	}

	@Override
	public Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		var result = BusinessRules.run(checkEmail(createCorporateCustomerRequest.getEmail()));
		
		if (result != null) {
			return result;
		}
		CorporateCustomer corporateCustomer = new CorporateCustomer();

		corporateCustomer.setCompanyName(createCorporateCustomerRequest.getCompanyName());
		corporateCustomer.setEmail(createCorporateCustomerRequest.getEmail());
		corporateCustomer.setPassword(createCorporateCustomerRequest.getPassword());
		corporateCustomer.setTaxNumber(createCorporateCustomerRequest.getTaxNumber());

		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult(Messages.CUSTOMERADD);
	}

	@Override
	public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer = this.corporateCustomerDao
				.getByTaxNumber(updateCorporateCustomerRequest.getTaxNumber());
		corporateCustomer.setUserId(updateCorporateCustomerRequest.getId());

		corporateCustomer.setCompanyName(updateCorporateCustomerRequest.getCompanyName());
		corporateCustomer.setEmail(updateCorporateCustomerRequest.getEmail());
		corporateCustomer.setPassword(updateCorporateCustomerRequest.getPassword());
		corporateCustomer.setTaxNumber(updateCorporateCustomerRequest.getTaxNumber());

		this.corporateCustomerDao.save(corporateCustomer);
		return new SuccessResult(Messages.CUSTOMERUPDATE);
	}

	@Override
	public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer = new CorporateCustomer();
		corporateCustomer.setUserId(this.corporateCustomerDao.getByTaxNumber(deleteCorporateCustomerRequest.getTaxNumber()).getUserId());

		this.corporateCustomerDao.deleteById(corporateCustomer.getUserId());
		return new SuccessResult(Messages.CUSTOMERDELETE);
	}

	@Override
	public DataResult<List<CorporateCustomer>> getAll() {
		return new SuccessDataResult<List<CorporateCustomer>>(this.corporateCustomerDao.findAll(),
				Messages.CUSTOMERLIST);
	}
	public Result checkEmail(String email) {

		if (this.customerDao.existsCustomerByEmail(email)) {
			return new ErrorResult(Messages.EMAILERROR);
		}
		return new SuccessResult();
	}
}
