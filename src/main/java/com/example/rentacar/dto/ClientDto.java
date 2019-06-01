package com.example.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ClientDto {

	public ClientDto(){}
	
	private Integer id;

	private String dni;

	private String name;

}
