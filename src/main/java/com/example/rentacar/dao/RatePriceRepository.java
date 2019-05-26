package com.example.rentacar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.model.entitity.RatePriceEntity;


public interface RatePriceRepository extends JpaRepository<RatePriceEntity,Integer>{

	List<RatePriceEntity> findAll();
}
