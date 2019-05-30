package com.example.rentacar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.rentacar.entitity.RatePriceEntity;


public interface RatePriceRepository extends JpaRepository<RatePriceEntity,Integer>{

	List<RatePriceEntity> findAll();
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "insert into rate_price_cars (cars_id_car, rate_prices_id_rate) values (:idCar, :idRate)")
	void saveOnRatePricesCars(
			@Param("idCar")Integer idCar,
			@Param("idRate")Integer idRate);
	
}
