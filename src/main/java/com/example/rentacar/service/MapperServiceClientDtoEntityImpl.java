package com.example.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.model.entitity.ClientEntity;

@Component
public class MapperServiceClientDtoEntityImpl implements MapperService<ClientDto, ClientEntity>{

	@Override
	public ClientDto map(ClientEntity gdoEntity) {
		ClientDto clientDto = new ClientDto();
		clientDto.setIdClient(gdoEntity.getIdclient());
		clientDto.setNameClient(gdoEntity.getNameClient());		
		return clientDto;
	}
	
	@Override
	public List<ClientDto> map(List<ClientEntity> gdoEntityList) {
		List<ClientDto> clientDtoList = null;
		
		return clientDtoList;
	}

}
