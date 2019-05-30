package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.RentDto;
import com.example.rentacar.entitity.RentEntity;

@Component
public class MapperServiceRentDtoEntityImpl implements MapperService<RentDto, RentEntity>{

	@Override
	public RentDto map(RentEntity rentEntity) {
		RentDto rentDto = new RentDto();
		rentDto.setIdRent(rentEntity.getIdRent());
		rentDto.setPriceRent(rentEntity.getPriceRent());
		rentDto.setStartRent(rentEntity.getStartRent());
		rentDto.setEndRent(rentEntity.getEndRent());
		return rentDto;
	}

	@Override
	public List<RentDto> map(List<RentEntity> rentEntityList) {
		List<RentDto> rentDtoList = new ArrayList<RentDto>();		
		RentEntity rentEntity = new RentEntity();
		Iterator<RentEntity> iterator = rentEntityList.iterator();
		while(iterator.hasNext()){				
			rentEntity = iterator.next();
			RentDto rentDto = new RentDto();
			rentDto.setIdRent(rentEntity.getIdRent());
			rentDto.setPriceRent(rentEntity.getPriceRent());
			rentDto.setStartRent(rentEntity.getStartRent());
			rentDto.setEndRent(rentEntity.getEndRent());
			rentDtoList.add(rentDto);			
		}
		return rentDtoList;
	}

}
