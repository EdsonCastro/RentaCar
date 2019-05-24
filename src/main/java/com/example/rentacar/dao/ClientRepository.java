package com.example.rentacar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.model.entitity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer>{

}
