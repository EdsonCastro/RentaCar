package com.example.rentacar.services;

import com.example.rentacar.dao.CarRepository;
import com.example.rentacar.entitity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<CarEntity> findAll(String name) {
		return carRepository.findAll();
	}

	@Override
	public Optional<CarEntity> findId(Integer id) {
		return carRepository.findById(id);
	}


	@Override
	public Optional<CarEntity> save(CarEntity carEntity) {
		return Optional.ofNullable( carRepository.saveAndFlush( carEntity ) );
	}	
	
	@Override
	public Optional<CarEntity> update( CarEntity carEntity) {

		return Optional.ofNullable(carRepository.saveAndFlush(carEntity));
	}

	@Override
	public void delete(Integer id) {
		carRepository.deleteById(id);
	}	
	
}
