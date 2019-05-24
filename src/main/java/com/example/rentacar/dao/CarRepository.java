package com.example.rentacar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.model.entitity.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{

}