package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.RatePriceDto;
import com.example.rentacar.entitity.RatePriceEntity;

@Component
public class MapperServiceRatePriceImpl implements MapperService<RatePriceEntity, RatePriceDto> {

	@Override
	public RatePriceEntity mapToEntity(RatePriceDto ratePriceDto) {
		RatePriceEntity ratePriceEntity = new RatePriceEntity();
		ratePriceEntity.setPrice(ratePriceDto.getPrice());
		ratePriceEntity.setStartDate( ratePriceDto.getStartRate());
		ratePriceEntity.setEndDate( ratePriceDto.getEndRate());
		System.out.println("Entra en mapToEntity de Rate.");
		return ratePriceEntity;
	}

	@Override
	public List<RatePriceEntity> mapToEntity(List<RatePriceDto> rentPriceDtoList) {
		List<RatePriceEntity> ratePriceEntityList = new ArrayList<RatePriceEntity>();		
		RatePriceDto ratePriceDto = new RatePriceDto();
		Iterator<RatePriceDto> iterator = rentPriceDtoList.iterator();
		while(iterator.hasNext()){	
			ratePriceDto = iterator.next();
			RatePriceEntity ratePriceEntity = new RatePriceEntity();
			ratePriceEntity.setPrice(ratePriceDto.getPrice());
			ratePriceEntity.setStartDate( ratePriceDto.getStartRate());
			ratePriceEntity.setEndDate( ratePriceDto.getEndRate());
			ratePriceEntityList.add(ratePriceEntity);			
		}
		System.out.println("Entra en mapToEntity de Rate.");
		return ratePriceEntityList;
	}

	@Override
	public RatePriceDto mapToDto(RatePriceEntity ratePriceEntity) {
		RatePriceDto ratePriceDto = new RatePriceDto(ratePriceEntity.getId(), ratePriceEntity.getPrice(), ratePriceEntity.getStartDate(), ratePriceEntity.getEndDate());
		return ratePriceDto;
	}

	@Override
	public List<RatePriceDto> mapToDto(List<RatePriceEntity> ratePriceEntityList) {
		List<RatePriceDto> ratePriceDtoList = new ArrayList<RatePriceDto>();
		ratePriceEntityList.forEach(item->{
			ratePriceDtoList.add(new RatePriceDto(item.getId(), item.getPrice(), item.getStartDate(), item.getEndDate()));
		});
		return ratePriceDtoList;
	}
}
