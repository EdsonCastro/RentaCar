package com.example.rentacar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.model.entitity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity,Integer>{

}