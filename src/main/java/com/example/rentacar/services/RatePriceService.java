package com.example.rentacar.services;

import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.RatePriceEntity;

import java.util.List;
import java.util.Optional;

public interface RatePriceService {
	
	List <RatePriceEntity> findAll(String name);
	
	Optional<RatePriceEntity> findId(Integer id);

	Optional<RatePriceEntity> save(RatePriceEntity ratePriceEntity);

	Optional<RatePriceEntity> update(RatePriceEntity ratePriceEntity);

	void delete(Integer id);
}
