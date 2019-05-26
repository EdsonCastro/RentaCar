package com.example.rentacar.service;

import java.util.Iterator;
import java.util.List;

import com.example.rentacar.dto.RentDto;
import org.springframework.stereotype.Component;
import com.example.rentacar.model.entitity.RentEntity;

@Component
public class MapperServiceRentEntityDtoImpl implements MapperService<RentEntity, RentDto>{

	@Override
	public RentEntity map(RentDto rentDto) {
		RentEntity rentEntity = new RentEntity();	
		rentEntity.setPriceRent(rentDto.getPriceRent());
		rentEntity.setStartRent(rentDto.getStartRent());
		rentEntity.setEndRent(rentDto.getEndRent());	
		return rentEntity;
	}

	@Override
	public List<RentEntity> map(List<RentDto> rentDtoList) {
		List<RentEntity> rentEntityList = null;		
		RentDto rentDto = new RentDto();
		Iterator<RentDto> iterator = rentDtoList.iterator();
		rentDto = iterator.next();
		while(iterator.hasNext()){
			rentDto = iterator.next();
			RentEntity rentEntity = new RentEntity();
			rentEntity.setPriceRent(rentDto.getPriceRent());
			rentEntity.setStartRent(rentDto.getStartRent());
			rentEntity.setEndRent(rentDto.getEndRent());
			rentEntityList.add(rentEntity);
		}
		return rentEntityList;
	}

}
