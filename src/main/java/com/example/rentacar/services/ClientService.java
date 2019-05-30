package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;

public interface ClientService {
	
	List <ClientEntity> findAllClients();
	
	List <ClientEntity> findClientName(String name);
	
	Optional<ClientEntity> findClientId(Integer id);
	
	Optional<ClientEntity> findClientDni(String id);
	
	void saveClient(ClientEntity clientEntity);
	
	void deleteClient(ClientEntity clientEntity);
}
