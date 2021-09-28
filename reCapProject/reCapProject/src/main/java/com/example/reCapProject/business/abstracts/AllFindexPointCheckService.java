package com.example.reCapProject.business.abstracts;

import com.example.reCapProject.entities.concretes.CorporateCustomer;
import com.example.reCapProject.entities.concretes.IndividualCustomer;

public interface AllFindexPointCheckService {
	
 int checkCorporateCustomerFindexPoint(CorporateCustomer corporateCustomer);
 int checkIndividualCustomerFindexPoint(IndividualCustomer individualCustomer);
	

}
