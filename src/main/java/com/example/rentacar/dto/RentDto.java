package com.example.rentacar.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.CarEntity;



@Data
@AllArgsConstructor
public class RentDto {

	public RentDto(){};

	private Integer id;

	private CarEntity car;

	private ClientEntity client;
	
	private Double price;
	
	private String startDate;
	
	private String endDate;
}
