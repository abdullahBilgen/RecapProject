package com.example.reCapProject.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Integer> {
	
	List<Invoice> getByCustomer_UserId(int customerId);
	List<Invoice> getAllByInvoiceDateLessThanEqualAndInvoiceDateGreaterThanEqual(Date startDate, Date endDate);

}
