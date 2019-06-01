package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import com.example.rentacar.entitity.ClientEntity;

public interface ClientService {
	
	List <ClientEntity> findAllClients(String name);
	
	Optional<ClientEntity> findClientId(Integer id);
	
	Optional<ClientEntity> findClientDni(String id);

	Optional<ClientEntity> saveClient(ClientEntity clientEntity);

	Optional<ClientEntity> updateClient(ClientEntity clientEntit);

	void deleteClient(Integer id);
}
