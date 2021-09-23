package com.example.reCapProject.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterDto {

	@NotNull
	@NotBlank(message="Kullanıcı adı giriniz.")
	private String firstName;
	@NotNull
	@NotBlank(message="Kullanıcı adı giriniz.")
	private String lastName;
	@NotNull
	@NotBlank(message="Mail boş geçilemez.")
	private String email;
	@NotNull
	@NotBlank(message = "Lütfen parola giriniz.")
	private String password;
}
