package com.example.rentacar.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatePriceDto {
	
	private Integer idRatePrice;
	
	private Integer priceRate;
	
	private Date startRate;
	
	private Date endRate;
	
	private Integer activeRate;
	
	private Integer idCoche;
}