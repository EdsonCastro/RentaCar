package com.example.rentacar.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.model.entitity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer>{

	
	List<ClientEntity> findAll();
}
