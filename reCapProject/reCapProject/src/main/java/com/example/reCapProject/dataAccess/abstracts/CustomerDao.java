package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reCapProject.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	@Query ("SELECT c.customerFindeks FROM Customer c WHERE userId=:userId")
	int getFindeksPointByCustomer_UserId(int userId);
}
