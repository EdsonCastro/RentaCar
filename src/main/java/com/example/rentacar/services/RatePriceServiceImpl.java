package com.example.rentacar.services;

import com.example.rentacar.dao.RatePriceRepository;
import com.example.rentacar.entitity.RatePriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RatePriceServiceImpl implements RatePriceService{

	@Autowired
	private RatePriceRepository ratePriceRepository;

	@Override
	public List<RatePriceEntity> findAll(String name) {
		return ratePriceRepository.findAll();
	}

	@Override
	public Optional<RatePriceEntity> findId(Integer id) {
		return ratePriceRepository.findById(id);
	}


	@Override
	public Optional<RatePriceEntity> save(RatePriceEntity ratePriceEntity) {
		return Optional.ofNullable( ratePriceRepository.saveAndFlush( ratePriceEntity ) );
	}	
	
	@Override
	public Optional<RatePriceEntity> update( RatePriceEntity ratePriceEntity) {
		return Optional.ofNullable(ratePriceRepository.saveAndFlush(ratePriceEntity));
	}

	@Override
	public void delete(Integer id) {
		ratePriceRepository.deleteById(id);
	}

}
