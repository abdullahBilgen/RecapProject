package com.example.reCapProject.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.CreditCard;


public interface  CreditCardDao extends JpaRepository<CreditCard, Integer>{
	
	List<CreditCard> getCreditCardByCustomer_UserId(int userId);
	
	
	

}
