package com.example.reCapProject.entities.request.update;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRepairRequest {

	@NotNull
	private int carId;

	private int carRepairId;

	@NotNull
	private Date returnDate;

	private String repairDescription;
	@NotNull
	private String repairPrice;

	@NotNull
	private Date repairDate;

	private boolean returnStatus;

}
