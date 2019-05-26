package com.example.rentacar.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentDto {

	private Integer idRent;
	
	private Integer price;
	
	private Date startRent;
	
	private Date endRent;	
}
