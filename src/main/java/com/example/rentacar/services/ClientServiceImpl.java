package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rentacar.dao.ClientRepository;
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
	public Optional<ClientEntity> updateClient( ClientEntity clientEntity) {
		return Optional.ofNullable(clientRepository.saveAndFlush(clientEntity));
	}

	@Override
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}	
	
}
