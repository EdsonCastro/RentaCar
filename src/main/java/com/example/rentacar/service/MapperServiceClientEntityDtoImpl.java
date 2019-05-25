package com.example.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.model.entitity.ClientEntity;

@Component
public class MapperServiceClientEntityDtoImpl implements MapperService<ClientEntity, ClientDto>{

	@Override
	public ClientEntity map(ClientDto gdoDto) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setNameClient(gdoDto.getNameClient());		
		return clientEntity;
	}

	@Override
	public List<ClientEntity> map(List<ClientDto> gdoDtoList) {
		List<ClientEntity> clientEntityList = null;
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setNameClient("hola");
		clientEntityList.add(clientEntity);
		return clientEntityList;
	}

	
}
