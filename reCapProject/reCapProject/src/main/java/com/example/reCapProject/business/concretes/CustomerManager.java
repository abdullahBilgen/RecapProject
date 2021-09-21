package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CustomerService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CustomerDao;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.request.CreateCustomerRequest;
import com.example.reCapProject.entities.request.UpdateCustomerRequest;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findAll(),Messages.GETALL);
	}

	@Override
	public DataResult<Customer> getById(int customerId) {
		return new SuccessDataResult<Customer> 
		(this.customerDao.getById(customerId),Messages.GETID);   
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		
		Customer customer =new Customer();
		customer.setCompanyName(createCustomerRequest.getCompanyName());
		customer.setEMail(createCustomerRequest.getEMail());
		customer.setPassword(createCustomerRequest.getPassword());
		customer.setFirstName(createCustomerRequest.getFirstName());
		customer.setLastName(createCustomerRequest.getLastName());
		
		this.customerDao.save(customer);  
		return new SuccessResult(Messages.ADD);  
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		
		Customer customer = new Customer();
		customer.setCompanyName(updateCustomerRequest.getCompanyName());
		customer.setEMail(updateCustomerRequest.getEmail());
		customer.setPassword(updateCustomerRequest.getPassword());
		
		this.customerDao.save(customer);
		return new SuccessResult(Messages.UPDATE); 
		                                
	}

	@Override
	public Result delete(Customer customer) {
		this.customerDao.delete(customer);  
		return new SuccessResult(Messages.DELETE); 
		                            
	}

}
