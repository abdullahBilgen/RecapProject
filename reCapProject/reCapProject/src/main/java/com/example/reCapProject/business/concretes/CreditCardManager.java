package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CreditCardService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.CreditCardDao;

import com.example.reCapProject.entities.concretes.CreditCard;
import com.example.reCapProject.entities.concretes.Customer;
import com.example.reCapProject.entities.request.create.CreateCreditCardRequest;
import com.example.reCapProject.entities.request.delete.DeleteCreditCardRequest;
import com.example.reCapProject.entities.request.update.UpdateCreditCardRequest;

@Service
public class CreditCardManager implements CreditCardService {

	private CreditCardDao creditCardDao;
	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao) {
		super();
		this.creditCardDao = creditCardDao;
	}

	@Override
	public DataResult<List<CreditCard>> getAll() {
		return new SuccessDataResult<List<CreditCard>>(this.creditCardDao.findAll(), Messages.GETALL);
	}

	@Override
	public DataResult<CreditCard> getById(int cardId) {
		return new SuccessDataResult<CreditCard>(this.creditCardDao.getById(cardId));
	}

	@Override
	public Result add(CreateCreditCardRequest createCreditCardRequest) {

		Customer customer = new Customer();
		customer.setUserId(createCreditCardRequest.getCustomerId());

		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber(createCreditCardRequest.getCardNumber());
		creditCard.setCardName(createCreditCardRequest.getCardName());
		creditCard.setCvc(createCreditCardRequest.getCvc());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDİTCARDADD);
	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardId(deleteCreditCardRequest.getCardId());
		
		this.creditCardDao.delete(creditCard);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {
		
		Customer customer = new Customer();
		customer.setUserId(updateCreditCardRequest.getCustomerId());

		
		CreditCard creditCard = this.creditCardDao.getById(updateCreditCardRequest.getCardId());
		creditCard.setCardNumber(updateCreditCardRequest.getCardNumber());
		creditCard.setCardName(updateCreditCardRequest.getCardName());
		creditCard.setCvc(updateCreditCardRequest.getCvc());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDUPDATE);
	}
}
