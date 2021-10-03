package com.example.reCapProject.business.abstracts;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Payment;
import com.example.reCapProject.entities.request.create.CreatePaymentRequest;
import com.example.reCapProject.entities.request.delete.DeletePaymentRequest;
import com.example.reCapProject.entities.request.update.UpdatePaymentRequest;

public interface PaymentService {
	
	DataResult<Payment> getById(int paymentId);

	Result add(CreatePaymentRequest createPaymentRequest);
	
	
}
