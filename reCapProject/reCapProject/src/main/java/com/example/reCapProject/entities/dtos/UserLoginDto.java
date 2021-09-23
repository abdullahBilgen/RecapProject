package com.example.reCapProject.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
	
	@NotBlank
	@NotNull
	private String email;
	
	@NotBlank
	@NotNull
	
	private String password;
}
