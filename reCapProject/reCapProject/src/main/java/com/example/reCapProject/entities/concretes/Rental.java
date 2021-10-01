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

import com.example.reCapProject.entities.abstracts.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rentals")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int rentalId;
	
	@Column(name = "returnStatus", columnDefinition = "boolean default true")
	private boolean returnStatus;
	
	@Column(name="rent_date")
	private Date rentDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@Column(name="pick_up_city")
	private String pickUpCity;
	
	@Column(name="delivery_city")
	private String deliveryCity;
	
	@Column(name="start_mileage")
	private String startingMileage;
	
	@Column(name="end_mileage")
	private String endMileage;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	
	@ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    
}