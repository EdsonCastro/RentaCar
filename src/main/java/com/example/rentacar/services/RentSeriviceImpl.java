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
	public List<RentEntity> findAll(String name) {
		return rentRepository.findAll();
	}

	@Override
	public Optional<RentEntity> findId(Integer id) {
		return rentRepository.findById(id);
	}


	@Override
	public Optional<RentEntity> save(RentEntity rentEntity) {
		return Optional.ofNullable( rentRepository.saveAndFlush( rentEntity ) );
	}

	@Override
	public Optional<RentEntity> update( RentEntity rentEntity) {
		return Optional.ofNullable(rentRepository.saveAndFlush( rentEntity));
	}

	@Override
	public void delete(Integer id) {
		rentRepository.deleteById(id);
	}

}
