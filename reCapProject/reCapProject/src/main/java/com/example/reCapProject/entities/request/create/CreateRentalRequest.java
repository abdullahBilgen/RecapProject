package com.example.reCapProject.entities.request.create;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.example.reCapProject.entities.dtos.AdditionalServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateRentalRequest  {
	
	
	@JsonIgnore
	private String pickUpCity;
	
	private String deliveryCity;
	
    private Date rentDate;
   
    private Date returnDate;

    
    @JsonIgnore
    private double amount;
   
    private int carId;
    private int customerId;
  
    private List<AdditionalServiceDto> additionalServiceDtos;
    
    @Valid
    private CreatePosRequest createPosRequest;
    
    
    
  
	

}
