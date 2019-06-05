package com.example.rentacar.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.rentacar.dao.CarRepository;
import com.example.rentacar.dao.ClientRepository;
import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.ClientEntity;
import com.mysql.cj.xdevapi.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.rentacar.dao.RentRepository;
import com.example.rentacar.entitity.RentEntity;

@Component
public class RentSeriviceImpl implements RentService{

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ClientRepository clientRepository;

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
		//Optional<CarEntity> OpCarEntity = carRepository.findById( rentEntity.getCar().getIdCar());
		//Optional<ClientEntity> OpClientEntity =  clientRepository.findById( rentEntity.getClient().getIdClient() );

		//System.out.println("miau: "+OpCarEntity.get()+" miau" );
		//System.out.println("miau: "+OpClientEntity.get()+" miau" );

		System.out.println("miau: "+rentEntity.getCar().getIdCar()+" miau" );
		System.out.println("miau: "+rentEntity.getClient().getIdClient()+" miau" );

			return Optional.ofNullable( rentRepository.save( rentEntity ));
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
