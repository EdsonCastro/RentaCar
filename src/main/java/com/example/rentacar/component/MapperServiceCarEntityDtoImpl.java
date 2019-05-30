package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.entitity.CarEntity;

@Component
public class MapperServiceCarEntityDtoImpl implements MapperService<CarEntity, CarDto>{

	@Override
	public CarEntity map(CarDto carDto) {
		CarEntity carEntity = new CarEntity();
		carEntity.setLicenseCar(carDto.getLicenseCar());
		carEntity.setNameCar(carDto.getNameCar());
		carEntity.setTypeCar(carDto.getTypeCar());
		return carEntity;
	}

	@Override
	public List<CarEntity> map(List<CarDto> carDtoList) {
		List<CarEntity> carEntityList = new ArrayList<CarEntity>();	
		CarDto carDto = new CarDto();
		Iterator<CarDto> iterator = carDtoList.iterator();
		carDto = iterator.next();
		while(iterator.hasNext()){
			carDto = iterator.next();
			CarEntity carEntity = new CarEntity();
			carEntity.setLicenseCar(carDto.getLicenseCar());
			carEntity.setNameCar(carDto.getNameCar());
			carEntity.setTypeCar(carDto.getTypeCar());
			carEntityList.add(carEntity);
		}
		return carEntityList;
	}
}
