package com.example.rentacar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.model.entitity.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity,Integer>{

	List<RentEntity> findAll();
	
}