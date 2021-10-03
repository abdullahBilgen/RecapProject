package com.example.reCapProject.business.abstracts;

import java.util.Date;
import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Invoice;
import com.example.reCapProject.entities.request.create.CreateInvoiceRequest;
import com.example.reCapProject.entities.request.delete.DeleteInvoiceRequest;
import com.example.reCapProject.entities.request.update.UpdateInvoiceRequest;

public interface InvoiceService {
	
	Result add(CreateInvoiceRequest createInvoiceRequest);
	
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	
	Result update(UpdateInvoiceRequest updaInvoiceRequest);
	
	
	DataResult<List<Invoice>> getAll();
	DataResult<List<Invoice>> getByCustomer_Id(int customerId);
	DataResult<List<Invoice>> getByInvoicesAllDate(Date startDate, Date endDate);
	

}
