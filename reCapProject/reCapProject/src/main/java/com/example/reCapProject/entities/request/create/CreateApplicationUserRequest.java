package com.example.reCapProject.entities.request.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationUserRequest {
 

	@NotNull
	@NotBlank
	private String firstName;
	

	@NotNull
	@NotBlank
	private String lastName;
	

	@NotNull
	@NotBlank
	private String email;
	

	@NotNull
	@NotBlank
	private String password;
}
