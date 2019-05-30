package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.RatePriceDto;
import com.example.rentacar.entitity.RatePriceEntity;

@Component
public class MapperServiceRatePriceEntityDtoImpl implements MapperService<RatePriceEntity, RatePriceDto> {

	@Override
	public RatePriceEntity map(RatePriceDto ratePriceDto) {
		RatePriceEntity ratePriceEntity = new RatePriceEntity();
		ratePriceEntity.setPriceRate(ratePriceDto.getPriceRate());
		ratePriceEntity.setStartRatePrice(ratePriceDto.getStartRate());
		ratePriceEntity.setEndRatePrice(ratePriceDto.getEndRate());				
		return ratePriceEntity;
	}

	@Override
	public List<RatePriceEntity> map(List<RatePriceDto> rentPriceDtoList) {
		List<RatePriceEntity> ratePriceEntityList = new ArrayList<RatePriceEntity>();		
		RatePriceDto ratePriceDto = new RatePriceDto();
		Iterator<RatePriceDto> iterator = rentPriceDtoList.iterator();
		while(iterator.hasNext()){	
			ratePriceDto = iterator.next();
			RatePriceEntity ratePriceEntity = new RatePriceEntity();
			ratePriceEntity.setPriceRate(ratePriceDto.getPriceRate());
			ratePriceEntity.setStartRatePrice(ratePriceDto.getStartRate());
			ratePriceEntity.setEndRatePrice(ratePriceDto.getEndRate());
			ratePriceEntityList.add(ratePriceEntity);			
		}
		return ratePriceEntityList;
	}

}
