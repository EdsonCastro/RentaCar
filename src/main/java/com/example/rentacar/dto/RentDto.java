package com.example.rentacar.dto;



import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.dto.CarDto;



@Data
@AllArgsConstructor
public class RentDto {

	public RentDto() {};

	public RentDto(Integer id, CarEntity car, ClientEntity client, Double price, String startDate, String endDate){};

	private Integer id;

	private CarDto car;

	private ClientDto client;
	
	private Double price;
	
	private String startDate;
	
	private String endDate;
}
