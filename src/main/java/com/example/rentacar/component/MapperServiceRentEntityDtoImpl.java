package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.rentacar.dto.RentDto;
import com.example.rentacar.entitity.RatePriceEntity;
import com.example.rentacar.entitity.RentEntity;

import org.springframework.stereotype.Component;

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
		List<RentEntity> rentEntityList = new ArrayList<RentEntity>();		
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
