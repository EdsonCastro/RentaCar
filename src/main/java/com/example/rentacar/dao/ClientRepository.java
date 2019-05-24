package com.example.rentacar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.model.entitity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

}
