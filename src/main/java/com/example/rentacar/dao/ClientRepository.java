package com.example.rentacar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rentacar.entitity.ClientEntity;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

	List<ClientEntity> findAll();

	Optional<ClientEntity> findByDni(String dni);
}
