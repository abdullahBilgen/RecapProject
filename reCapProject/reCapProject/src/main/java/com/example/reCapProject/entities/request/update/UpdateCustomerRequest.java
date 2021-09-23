package com.example.reCapProject.entities.request.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
	
	@NotNull
	private String companyName;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
}
