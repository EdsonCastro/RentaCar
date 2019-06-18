package com.example.rentacar.dto;



import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class RentDto {

	public RentDto() {};



	private Integer id;

	@NotNull(message =  "El campo car es nulo.")
	private CarDto car;

	private ClientDto client;
	
	private Double price;
	
	private String startDate;
	
	private String endDate;
}
