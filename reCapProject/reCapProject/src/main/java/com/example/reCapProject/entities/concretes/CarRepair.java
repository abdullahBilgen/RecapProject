package com.example.reCapProject.entities.concretes;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="car_repairs")
@Entity
public class CarRepair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_repair_ıd")
	private int carRepairId;
	
	@Column(name="repair_description")
	private String repairDescription;
	
	@Column(name = "return_status")
	private boolean returnStatus;
	
	@Column(name="repair_price")
	private String repairPrice;
	
	@Column(name="repair_date")
	private Date repairDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;



	
	
	
	
	

}
