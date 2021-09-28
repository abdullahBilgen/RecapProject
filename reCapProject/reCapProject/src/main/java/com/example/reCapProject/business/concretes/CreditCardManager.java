package com.example.reCapProject.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.CreditCardService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
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
		return new SuccessDataResult<List<CreditCard>>(this.creditCardDao.findAll(), Messages.CREDITCARDLIST);
	}

	@Override
	public DataResult<CreditCard> getById(int customerId) {
		return new SuccessDataResult<CreditCard>(this.creditCardDao.getById(customerId), Messages.CREDITCARDLIST);
	}

	public Result add(CreateCreditCardRequest createCreditCardRequest) {

		var result = BusinessRules.run(checkCardControllers(createCreditCardRequest.getCardNumber()));

		if (result != null) {
			return result;
		}

		Customer customer = new Customer();
		customer.setUserId(createCreditCardRequest.getCustomerId());

		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber(createCreditCardRequest.getCardNumber());
		creditCard.setCardName(createCreditCardRequest.getCardName());
		creditCard.setCvc(createCreditCardRequest.getCvc());
		creditCard.setPullDate(createCreditCardRequest.getPullDate());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDADD);

	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardId(deleteCreditCardRequest.getCardId());

		this.creditCardDao.delete(creditCard);
		return new SuccessResult(Messages.CREDITCARDELETE);
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {

		Customer customer = new Customer();
		customer.setUserId(updateCreditCardRequest.getCustomerId());

		CreditCard creditCard = this.creditCardDao.getById(updateCreditCardRequest.getCardId());
		creditCard.setCardNumber(updateCreditCardRequest.getCardNumber());
		creditCard.setCardName(updateCreditCardRequest.getCardName());
		creditCard.setCvc(updateCreditCardRequest.getCvc());
		creditCard.setPullDate(updateCreditCardRequest.getPullDate());

		creditCard.setCustomer(customer);

		this.creditCardDao.save(creditCard);
		return new SuccessResult(Messages.CREDITCARDUPDATE);

	}

	public Result checkCardControllers(String cardNumber) {

		String regex = "^4[0-9]{3} [0-9]{4} [0-9]{4} [0-9]{4}$";
		
//		"^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + 
//        "(?<mastercard>5[1-5][0-9]{14})|" +
//        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
//        "(?<amex>3[47][0-9]{13})|" +
//        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + 
//        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNumber);

		if (!matcher.matches()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	

	
	
	

}
