package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;

@Component
public class MapperServiceClientEntityDtoImpl implements MapperService<ClientDto, ClientEntity>{

	@Override
	public ClientDto map(ClientEntity clientEntity) {
		ClientDto clientDto = new ClientDto();
		clientDto.setId(clientEntity.getId());
		clientDto.setDni(clientEntity.getDni());
		clientDto.setName(clientEntity.getName());		
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
			clientDto.setId(clientEntity.getId());
			clientDto.setDni(clientEntity.getDni());
			clientDto.setName(clientEntity.getName());
			clientDtoList.add(clientDto);			
		}
		return clientDtoList;
	}
}
