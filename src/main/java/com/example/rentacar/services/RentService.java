package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import com.example.rentacar.entitity.RentEntity;

public interface RentService {
	List <RentEntity> findAllRents();
	
	Optional<RentEntity> findRentId(Integer id);	
	
	void saveRent(RentEntity rentEntity);
	
	void deleteRent(RentEntity rentEntity);
}
