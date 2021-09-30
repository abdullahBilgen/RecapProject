package com.example.reCapProject.entities.request.create;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateRentalRequest  {
	
	private String pickUpCity;
	
	private String deliveryCity;

    private Date rentDate;
   
    private Date returnDate;
    
    private boolean returnStatus;
   
    private int carId;
    
    private int customerId;
    
    private String startingMileage;
}
