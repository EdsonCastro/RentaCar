package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.RentEntity;

@Component
public class MapperServiceClientImpl implements MapperService<ClientEntity, ClientDto>{

	@Override
	public ClientEntity mapToEntity(ClientDto clientDto) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(clientDto.getName());
		clientEntity.setDni(clientDto.getDni());
		return clientEntity;
	}

	@Override
	public List<ClientEntity> mapToEntity(List<ClientDto> clientDtoList) {
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

	@Override
	public ClientDto mapToDto(ClientEntity clientEntity) {
		return (new ClientDto(clientEntity.getId(),clientEntity.getDni(),clientEntity.getName()));
	}

	@Override
	public List<ClientDto> mapToDto(List<ClientEntity> clientEntityList) {
		List<ClientDto> clientDtoList = new ArrayList<ClientDto>();
		clientEntityList.forEach(item->{
			clientDtoList.add(new ClientDto(item.getId(),item.getDni(),item.getName()));
		});
		return clientDtoList;
	}


}
