package com.example.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.model.entitity.ClientEntity;

@Component
public class MapperServiceClientImpl implements MapperService<ClientDto, ClientEntity>{

	@Override
	public ClientDto map(ClientEntity gdoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientDto> map(List<ClientEntity> gdoDtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
