package com.example.rentacar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.entitity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity,Integer>{

	List<CarEntity> findAll();
	
}