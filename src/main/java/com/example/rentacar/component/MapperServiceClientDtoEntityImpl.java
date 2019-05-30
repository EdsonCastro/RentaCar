package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.RentEntity;

@Component
public class MapperServiceClientDtoEntityImpl implements MapperService<ClientEntity, ClientDto>{

	@Override
	public ClientEntity map(ClientDto clientDto) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(clientDto.getName());
		clientEntity.setDni(clientDto.getDni());
		return clientEntity;
	}

	@Override
	public List<ClientEntity> map(List<ClientDto> clientDtoList) {
		List<ClientEntity> clientEntityList = new ArrayList<ClientEntity>();	
		ClientDto clientDto = new ClientDto();
		Iterator<ClientDto> iterator = clientDtoList.iterator();
		clientDto = iterator.next();
		while(iterator.hasNext()){
			clientDto = iterator.next();
			ClientEntity clientEntity = new ClientEntity();
			clientEntity.setName(clientDto.getName());
			clientEntity.setDni(clientDto.getDni());
			clientEntityList.add(clientEntity);
		}
		return clientEntityList;
	}

	
}
