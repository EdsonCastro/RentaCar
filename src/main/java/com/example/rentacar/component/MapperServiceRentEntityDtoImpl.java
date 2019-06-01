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
	public RentEntity mapToEntity(RentDto rentDto) {
		RentEntity rentEntity = new RentEntity();	
		/*rentEntity.setPriceRent(rentDto.getPriceRent());
		rentEntity.setStartRent(rentDto.getStartRent());
		rentEntity.setEndRent(rentDto.getEndRent());*/	
		return rentEntity;
	}

	@Override
	public List<RentEntity> mapToEntity(List<RentDto> rentDtoList) {
		List<RentEntity> rentEntityList = new ArrayList<RentEntity>();		
		/*RentDto rentDto = new RentDto();
		Iterator<RentDto> iterator = rentDtoList.iterator();
		rentDto = iterator.next();
		while(iterator.hasNext()){
			rentDto = iterator.next();
			RentEntity rentEntity = new RentEntity();
			rentEntity.setPriceRent(rentDto.getPriceRent());
			rentEntity.setStartRent(rentDto.getStartRent());
			rentEntity.setEndRent(rentDto.getEndRent());
			rentEntityList.add(rentEntity);
		}*/
		return rentEntityList;
	}


	@Override
	public RentDto mapToDto(RentEntity rentEntity) {
		RentDto rentDto = new RentDto();
		/*rentDto.setIdRent(rentEntity.getIdRent());
		rentDto.setPriceRent(rentEntity.getPriceRent());
		rentDto.setStartRent(rentEntity.getStartRent());
		rentDto.setEndRent(rentEntity.getEndRent());*/
		return rentDto;
	}

	@Override
	public List<RentDto> mapToDto(List<RentEntity> rentEntityList) {
		List<RentDto> rentDtoList = new ArrayList<RentDto>();
		/*RentEntity rentEntity = new RentEntity();
		Iterator<RentEntity> iterator = rentEntityList.iterator();
		while(iterator.hasNext()){
			rentEntity = iterator.next();
			RentDto rentDto = new RentDto();
			rentDto.setIdRent(rentEntity.getIdRent());
			rentDto.setPriceRent(rentEntity.getPriceRent());
			rentDto.setStartRent(rentEntity.getStartRent());
			rentDto.setEndRent(rentEntity.getEndRent());
			rentDtoList.add(rentDto);
		}*/
		return rentDtoList;
	}

}
