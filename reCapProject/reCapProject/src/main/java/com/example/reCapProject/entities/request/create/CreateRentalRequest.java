package com.example.reCapProject.entities.request.create;

import java.util.Date;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest  {
	
    @NotNull
    private Date rentDate;
    
    private Date returnDate;
    
    private boolean returnRentControl;
    private int carId;
    private int customerId;
}
