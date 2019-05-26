package com.example.rentacar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.model.entitity.ClientEntity;

@Component
public class MapperServiceClientDtoEntityImpl implements MapperService<ClientDto, ClientEntity>{

	@Override
	public ClientDto map(ClientEntity clientEntity) {
		ClientDto clientDto = new ClientDto();
		clientDto.setIdClient(clientEntity.getIdclient());
		clientDto.setNameClient(clientEntity.getNameClient());		
		return clientDto;
	}
	
	@Override
	public List<ClientDto> map(List<ClientEntity> clientEntityList) {
		List<ClientDto> clientDtoList = new ArrayList<ClientDto>();		
		ClientEntity clientEntity = new ClientEntity();
		Iterator<ClientEntity> iterator = clientEntityList.iterator();
		while(iterator.hasNext()){				
			clientEntity = iterator.next();
			ClientDto clientDto = new ClientDto();
			clientDto.setIdClient(clientEntity.getIdclient());
			clientDto.setNameClient(clientEntity.getNameClient());
			clientDtoList.add(clientDto);			
		}
		return clientDtoList;
	}

}
