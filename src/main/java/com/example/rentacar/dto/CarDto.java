package com.example.rentacar.dto;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CarDto {

	public CarDto(){}

	private Integer id;
	
	private String carPlate;
	
	private String registrationYear;

}
