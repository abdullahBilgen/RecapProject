package com.example.reCapProject.entities.request.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequest {
	
	
	@NotNull
	@NotBlank
	private String companyName;
	@NotNull
	@NotBlank
	private String taxNumber;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String email;
}
