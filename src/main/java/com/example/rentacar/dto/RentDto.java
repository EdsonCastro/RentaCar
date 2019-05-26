package com.example.rentacar.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentDto {

	private Integer idRent;
	
	private Integer priceRent;
	
	private Date startRent;
	
	private Date endRent;
	
	private Integer idClient;
	
	private Integer idCoche;
}
