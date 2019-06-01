package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rentacar.component.MapperService;
import com.example.rentacar.dao.ClientRepository;
import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;

@Component
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<ClientEntity> findAllClients(String name) {
		return clientRepository.findAll();
	}

	@Override
	public Optional<ClientEntity> findClientId(Integer id) {	
		return clientRepository.findById(id);
	}

	@Override
	public Optional<ClientEntity> findClientDni(String dni) {		
		return clientRepository.findByDni(dni);
	}

	@Override
	public Optional<ClientEntity> saveClient(ClientEntity clientEntity) {
		return Optional.ofNullable( clientRepository.saveAndFlush( clientEntity ) );
	}	
	
	@Override
	public void updateClient(ClientEntity clientEntity, ClientDto clientDto) {
		clientEntity.setDni(clientDto.getDni());
		clientEntity.setName(clientDto.getName());
		clientRepository.saveAndFlush(clientEntity);
	}

	@Override
	public void deleteClient(ClientEntity clientEntity) {
		clientRepository.delete(clientEntity);		
	}	
	
}
