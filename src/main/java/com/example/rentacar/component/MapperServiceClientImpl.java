package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;


@Component
public class MapperServiceClientImpl implements MapperService<ClientEntity, ClientDto>{

	@Override
	public ClientEntity mapToEntity(ClientDto clientDto) {
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setIdClient(clientDto.getId());
		clientEntity.setName(clientDto.getName());
		clientEntity.setDni(clientDto.getDni());
		System.out.println("Entra en mapToEntity de Cliente.");
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
			clientEntity.setIdClient(clientDto.getId());
			clientEntity.setName(clientDto.getName());
			clientEntity.setDni(clientDto.getDni());
			clientEntityList.add(clientEntity);
		}
		System.out.println("Entra en mapToEntity de Cliente.");
		return clientEntityList;
	}

	@Override
	public ClientDto mapToDto(ClientEntity clientEntity) {
		return (new ClientDto(clientEntity.getIdClient(),clientEntity.getDni(),clientEntity.getName()));
	}

	@Override
	public List<ClientDto> mapToDto(List<ClientEntity> clientEntityList) {
		List<ClientDto> clientDtoList = new ArrayList<ClientDto>();
		clientEntityList.forEach(item->{
			clientDtoList.add(new ClientDto(item.getIdClient(),item.getDni(),item.getName()));
		});
		return clientDtoList;
	}


}
