package com.example.reCapProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CreditCardValidatorService;
import com.example.reCapProject.business.abstracts.PaymentService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CreditCardDao;
import com.example.reCapProject.dataAccess.abstracts.PaymentDao;
import com.example.reCapProject.entities.concretes.CreditCard;
import com.example.reCapProject.entities.concretes.Payment;
import com.example.reCapProject.entities.concretes.Rental;
import com.example.reCapProject.entities.request.create.CreatePaymentRequest;
import com.example.reCapProject.entities.request.delete.DeletePaymentRequest;
import com.example.reCapProject.entities.request.update.UpdatePaymentRequest;

@Service
public class PaymentManager implements PaymentService {
	
private PaymentDao paymentDao;
private CreditCardValidatorService creditCardValidatorService;
private CreditCardDao creditCardDao;
	
	@Autowired
	public PaymentManager(PaymentDao paymentDao,CreditCardDao creditCardDao, CreditCardValidatorService creditCardValidatorService) {
		super();
		this.paymentDao = paymentDao;
		this.creditCardValidatorService=creditCardValidatorService;
		this.creditCardDao=creditCardDao;
	}

	@Override
	public DataResult<Payment> getById(int paymentId) {
		return new SuccessDataResult<Payment>(this.paymentDao.getById(paymentId));
	}

	@Override
	public Result add(CreatePaymentRequest createPaymentRequest) {
		
		CreditCard creditCard=this.creditCardDao.getById(createPaymentRequest.getCreditId());
		creditCard.setCardId(createPaymentRequest.getCreditId());
		
		Rental rental = new Rental();
		rental.setRentalId(createPaymentRequest.getRentalId());
			
		Payment payment = new Payment();
		payment.setCreditCard(creditCard);
		payment.setRental(rental);
		
		this.paymentDao.save(payment);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdatePaymentRequest updatePaymentRequest) {
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardId(updatePaymentRequest.getCreditId());
		
		Rental rental = new Rental();
		rental.setRentalId(updatePaymentRequest.getRentalId());
	
		Payment payment = new Payment();
		payment.setCreditCard(creditCard);
		payment.setRental(rental);
		
		this.paymentDao.save(payment);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeletePaymentRequest deletePaymentRequest) {
		Payment payment = this.paymentDao.getById(deletePaymentRequest.getPaymentId());
		
		this.paymentDao.delete(payment);
		return new SuccessResult();
	}
}