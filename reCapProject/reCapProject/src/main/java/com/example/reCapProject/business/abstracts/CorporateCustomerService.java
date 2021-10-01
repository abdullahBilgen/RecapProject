package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.CorporateCustomer;

import com.example.reCapProject.entities.request.create.CreateCorporateCustomerRequest;

import com.example.reCapProject.entities.request.delete.DeleteCorporateCustomerRequest;

import com.example.reCapProject.entities.request.update.UpdateCorporateCustomerRequest;

public interface CorporateCustomerService {

	Result add(CreateCorporateCustomerRequest createCorporateCustomerRequest);

	Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

	Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);

	DataResult<List<CorporateCustomer>> getAll();
}
