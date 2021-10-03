package com.example.reCapProject.entities.request.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {
	
	private int id;

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
