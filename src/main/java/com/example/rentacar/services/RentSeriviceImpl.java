package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rentacar.dao.RentRepository;
import com.example.rentacar.entitity.RentEntity;

@Component
public class RentSeriviceImpl implements RentService{

	@Autowired
	private RentRepository rentRepository;	
	
	@Override
	public List<RentEntity> findAllRents() {
		return rentRepository.findAll();
	}

	@Override
	public Optional<RentEntity> findRentId(Integer id) {
		return null;
	}

	@Override
	public void saveRent(RentEntity rentEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRent(RentEntity rentEntity) {
		// TODO Auto-generated method stub
		
	}

	
}
