package com.example.rentacar.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RatePriceDto {
	
	private Integer id;
	
	private Integer price;
	
	private Date startRate;
	
	private Date endRate;
}