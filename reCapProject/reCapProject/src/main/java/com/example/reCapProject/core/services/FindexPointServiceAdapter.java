package com.example.reCapProject.core.services;


import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.AllFindexPointCheckService;
import com.example.reCapProject.entities.concretes.CorporateCustomer;

import com.example.reCapProject.entities.concretes.IndividualCustomer;

@Service
public class FindexPointServiceAdapter implements AllFindexPointCheckService{

	@Override
	public int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer) {
		FindexPointService findexPointService= new FindexPointService();
		return findexPointService.corporateCustomerFindexPoint(corporateCustomer.getTaxNumber());
	}

	@Override
	public int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer) {
		FindexPointService findexPointService= new FindexPointService();
		return findexPointService.individualCustomerFindexPoint(individualCustomer.getIdentityNumber());
	}


		

	
}
