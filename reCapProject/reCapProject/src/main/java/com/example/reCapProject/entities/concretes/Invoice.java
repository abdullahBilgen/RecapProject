package com.example.reCapProject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invoice_id")
	private int invoiceId;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="rent_date")
	private Date rentDate;
	@Column(name="return_date")
	private Date returnDate;

	@Column(name="total_rent_day")
	private Long totalRentDay;
	
	@Column(name="invoice_date")
	private Date invoiceDate;
	
	@Column(name="invoice_amount")
	private String invoiceAmount;
	
	@OneToOne
	@JoinColumn(name="rental_id")
	private Rental rental;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	

}
