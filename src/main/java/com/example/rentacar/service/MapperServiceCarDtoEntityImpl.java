package com.example.rentacar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.model.entitity.CarEntity;

@Component
public class MapperServiceCarDtoEntityImpl implements MapperService<CarDto, CarEntity>{

	@Override
	public CarDto map(CarEntity carEntity) {
		CarDto carDto = new CarDto();
		carDto.setIdCar(carEntity.getIdCar());
		carDto.setLicenseCar(carEntity.getLicenseCar());
		carDto.setNameCar(carEntity.getNameCar());
		carDto.setTypeCar(carEntity.getTypeCar());	
		return carDto;
	}

	@Override
	public List<CarDto> map(List<CarEntity> cartEntityList) {
		List<CarDto> carDtoList = new ArrayList<CarDto>();		
		CarEntity carEntity = new CarEntity();
		Iterator<CarEntity> iterator = cartEntityList.iterator();
		while(iterator.hasNext()){				
			carEntity = iterator.next();
			CarDto carDto = new CarDto();
			carDto.setIdCar(carEntity.getIdCar());
			carDto.setLicenseCar(carEntity.getLicenseCar());
			carDto.setNameCar(carEntity.getNameCar());
			carDto.setTypeCar(carEntity.getTypeCar());
			carDtoList.add(carDto);			
		}
		return carDtoList;
	}

}
