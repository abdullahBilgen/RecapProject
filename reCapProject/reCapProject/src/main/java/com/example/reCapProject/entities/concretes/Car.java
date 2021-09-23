package com.example.reCapProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="car_id")
	private int carId;
	
	@Column(name="car_name")
	private String carName;
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="daily_price")
	private double dailyPrice;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name="car_findeks")
	private int carFindeks;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@JsonIgnore
	@OneToMany(mappedBy="car")
	private List<Rental> rentals;
	
	@OneToMany(mappedBy="car")
    private List<CarImage> carImages;
}
