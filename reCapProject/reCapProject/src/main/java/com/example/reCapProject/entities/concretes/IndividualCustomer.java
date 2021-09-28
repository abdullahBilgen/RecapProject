package com.example.reCapProject.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="individual_customers")
@Entity
public class IndividualCustomer extends Customer {
	
	@Column(name="identity_number")
	private String identityNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;

}
