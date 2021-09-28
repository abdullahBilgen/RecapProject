package com.example.reCapProject.entities.concretes;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="credit_cards")
@Entity

public class CreditCard {
	@Id
	@GeneratedValue
	@Column(name="credit_id")
	private int cardId;
	@Column(name="card_name")
	private String cardName;
	@Column(name="card_number")
	private String cardNumber;
	@Column(name="cvc")
	private String cvc;
	
	@Column(name="pull_date")
	private Date pullDate;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

}
