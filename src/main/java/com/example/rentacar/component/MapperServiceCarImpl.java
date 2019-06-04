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
		//carEntity.setId( carDto.getId() );
		carEntity.setCarPlate(carDto.getCarPlate());
		carEntity.setRegistrationYear(carDto.getRegistrationYear());
		System.out.println("Entra en mapToEntity de Car.");
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
			//carEntity.setId( carDto.getId() );
			carEntity.setCarPlate(carDto.getCarPlate());
			carEntity.setRegistrationYear(carDto.getRegistrationYear());
			carEntityList.add(carEntity);
		}
		System.out.println("Entra en mapToEntity de Car.");
		return carEntityList;
	}

	@Override
	public CarDto mapToDto(CarEntity carEntity) {
		CarDto carDto = new CarDto(carEntity.getIdCar(), carEntity.getCarPlate(), carEntity.getRegistrationYear());
		return carDto;
	}

	@Override
	public List<CarDto> mapToDto(List<CarEntity> cartEntityList) {
		List<CarDto> carDtoList = new ArrayList<CarDto>();
		cartEntityList.forEach(item->{
			carDtoList.add(new CarDto(item.getIdCar(),item.getCarPlate(),item.getRegistrationYear()));
		});
		return carDtoList;
	}

}
