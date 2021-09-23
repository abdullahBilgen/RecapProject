package com.example.reCapProject.entities.request.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
	
	@NotNull
	@NotBlank
	private String eMail;
	
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private int customerFindeks;
}
