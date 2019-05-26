package com.example.rentacar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rentacar.model.entitity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer>{
	
	List<ClientEntity> findAll();
	
	//poner bien consulta fixme
	@Query(nativeQuery = true, value = "select c from Client c where c.id_client = id")
	List<ClientEntity> findRentsClient(Integer id);
}
