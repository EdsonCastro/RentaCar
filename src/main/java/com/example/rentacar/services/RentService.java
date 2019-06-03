package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import com.example.rentacar.entitity.RentEntity;

public interface RentService {

	List <RentEntity> findAll(String name);

	Optional<RentEntity> findId(Integer id);

	Optional<RentEntity> save(RentEntity rentEntity);

	Optional<RentEntity> update(RentEntity rentEntity);

	void delete(Integer id);
}