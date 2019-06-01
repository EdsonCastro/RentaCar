package com.example.rentacar.services;

import com.example.rentacar.entitity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface RatePriceService {
	
	List <CarEntity> findAll(String name);
	
	Optional<CarEntity> findId(Integer id);

	Optional<CarEntity> save(CarEntity carEntity);

	Optional<CarEntity> update(CarEntity carEntity);

	void delete(Integer id);
}
