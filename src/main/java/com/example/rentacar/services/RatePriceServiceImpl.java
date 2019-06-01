package com.example.rentacar.services;

import com.example.rentacar.dao.ClientRepository;
import com.example.rentacar.entitity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RatePriceServiceImpl implements ClientService{

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
	public Optional<ClientEntity> updateClient( ClientEntity clientEntit) {
		return Optional.ofNullable(clientRepository.saveAndFlush(clientEntit));
	}

	@Override
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}	
	
}
