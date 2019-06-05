package com.example.rentacar.dto;



import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class RentDto {

	public RentDto() {};



	private Integer id;

	private CarEntity car;

	private ClientEntity client;
	
	private Double price;
	
	private String startDate;
	
	private String endDate;
}
