package com.example.reCapProject.business.concretes;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.InvoiceService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CustomerDao;
import com.example.reCapProject.dataAccess.abstracts.InvoiceDao;
import com.example.reCapProject.dataAccess.abstracts.RentalDao;
import com.example.reCapProject.entities.abstracts.Customer;
import com.example.reCapProject.entities.concretes.Invoice;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreateInvoiceRequest;
import com.example.reCapProject.entities.request.delete.DeleteInvoiceRequest;
import com.example.reCapProject.entities.request.update.UpdateInvoiceRequest;
@Service
public class InvoiceManager implements InvoiceService {
	
	private RentalDao rentalDao;
	private CustomerDao customerDao;
	private InvoiceDao invoiceDao;
	
	@Autowired
	public InvoiceManager(RentalDao rentalDao, CustomerDao customerDao, InvoiceDao invoiceDao) {
		super();
		this.rentalDao = rentalDao;
		this.customerDao = customerDao;
		this.invoiceDao = invoiceDao;
	}

	@Override
	public Result add(CreateInvoiceRequest createInvoiceRequest) {
		
		Customer customer = new Customer();
		customer.setUserId(createInvoiceRequest.getCustomerId());
		
		Rental rental= new Rental();
		rental.setRentalId(createInvoiceRequest.getRentalId());
		
		Invoice invoice = new Invoice();
		invoice.setInvoiceAmount(createInvoiceRequest.getInvoiceAmount());
		invoice.setInvoiceDate(createInvoiceRequest.getInvoiceDate());
		invoice.setInvoiceNumber(createInvoiceRequest.getInvoiceNumber());
		
		invoice.setRentDate(this.rentalDao.getById(createInvoiceRequest.getRentalId()).getRentDate());
		invoice.setReturnDate(this.rentalDao.getById(createInvoiceRequest.getRentalId()).getReturnDate());
		
		//EREN-DOĞANCAN KOD 15-17
		invoice.setTotalRentDay(ChronoUnit.DAYS.between(
		this.rentalDao.getById(createInvoiceRequest.getRentalId()).getRentDate().toInstant(),
		this.rentalDao.getById(createInvoiceRequest.getRentalId()).getReturnDate().toInstant()));
		
		invoice.setCustomer(customer);
		invoice.setRental(rental);
		
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEADD);
		
	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		Invoice invoice= this.invoiceDao.getById(deleteInvoiceRequest.getInvoiceId());
		
		this.invoiceDao.delete(invoice);
		return new SuccessResult(Messages.INVOICEDELETE);
	}

	@Override
	public Result update(UpdateInvoiceRequest updaInvoiceRequest) {
		Customer customer = new Customer();
		customer.setUserId(updaInvoiceRequest.getCustomerId());
		
		Rental rental= new Rental();
		rental.setRentalId(updaInvoiceRequest.getRentalId());
		
		Invoice invoice = new Invoice();
		invoice.setInvoiceAmount(updaInvoiceRequest.getInvoiceAmount());
		invoice.setInvoiceDate(updaInvoiceRequest.getInvoiceDate());
		invoice.setInvoiceNumber(updaInvoiceRequest.getInvoiceNumber());
		invoice.setInvoiceId(updaInvoiceRequest.getInvoiceId());
		
		//EREN-DOĞANCAN KOD 15-17
		invoice.setTotalRentDay(ChronoUnit.DAYS.between(
		this.rentalDao.getById(updaInvoiceRequest.getRentalId()).getRentDate().toInstant(),
		this.rentalDao.getById(updaInvoiceRequest.getRentalId()).getReturnDate().toInstant()));
		
		invoice.setCustomer(customer);
		invoice.setRental(rental);
		
		this.invoiceDao.save(invoice);
		return new SuccessResult(Messages.INVOICEADD);
	}

	@Override
	public DataResult<List<Invoice>> getAll() {
		return new SuccessDataResult<List<Invoice>>(this.invoiceDao.findAll());
				
	}

	@Override
	public DataResult<List<Invoice>> getByCustomer_Id(int customerId) {
		return new SuccessDataResult<List<Invoice>>
		(this.invoiceDao.getByCustomer_UserId(customerId),Messages.INVOICELIST);
	}

	@Override
	public DataResult<List<Invoice>> getByInvoicesAllDate(Date startDate, Date endDate) {
		return new SuccessDataResult<List<Invoice>>
		(this.invoiceDao.getAllByInvoiceDateLessThanEqualAndInvoiceDateGreaterThanEqual(startDate, endDate),Messages.INVOICELIST);
	}
}