package com.example.reCapProject.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.PaymentService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Payment;
import com.example.reCapProject.entities.request.create.CreatePaymentRequest;

import com.example.reCapProject.entities.request.delete.DeletePaymentRequest;

import com.example.reCapProject.entities.request.update.UpdatePaymentRequest;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
	
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Payment> getById(int paymentId) {
		return this.paymentService.getById(paymentId);
	}
	

}
