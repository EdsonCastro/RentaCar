package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.entitity.CarEntity;

@Component
public class MapperServiceCarImpl implements MapperService<CarEntity, CarDto>{

	@Override
	public CarEntity mapToEntity(CarDto carDto) {
		CarEntity carEntity = new CarEntity();
		carEntity.setLicenseCar(carDto.getLicenseCar());
		carEntity.setNameCar(carDto.getNameCar());
		carEntity.setTypeCar(carDto.getTypeCar());
		return carEntity;
	}

	@Override
	public List<CarEntity> mapToEntity(List<CarDto> carDtoList) {
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

	@Override
	public CarDto mapToDto(CarEntity carEntity) {
		CarDto carDto = new CarDto();
		carDto.setIdCar(carEntity.getIdCar());
		carDto.setLicenseCar(carEntity.getLicenseCar());
		carDto.setNameCar(carEntity.getNameCar());
		carDto.setTypeCar(carEntity.getTypeCar());
		return carDto;
	}

	@Override
	public List<CarDto> mapToDto(List<CarEntity> cartEntityList) {
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
