package com.example.reCapProject.entities.request.delete;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarRepairRequest {
	
	@NotNull
	@NotBlank
	private int carRepairId;
}
