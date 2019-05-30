package com.example.rentacar.dto;



import lombok.Data;

@Data
public class RentDto {

	private Integer id;
	
	private Double price;
	
	private String startDate;
	
	private String endDate;
	
	private Integer client;
	
	private Integer car;
}
