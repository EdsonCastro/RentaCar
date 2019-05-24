package com.example.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.CarDto;
import com.example.rentacar.model.entitity.CarEntity;

@Component
public class MapperServiceCarImpl implements MapperService<CarDto, CarEntity>{

	@Override
	public CarDto map(CarEntity gdoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarDto> map(List<CarEntity> gdoDtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
