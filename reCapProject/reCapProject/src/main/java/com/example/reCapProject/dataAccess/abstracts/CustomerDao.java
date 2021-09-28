package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.reCapProject.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	
	boolean existsCustomerByEmail(String email);


	
	

}
