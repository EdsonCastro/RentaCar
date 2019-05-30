package com.example.rentacar.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.dto.RatePriceDto;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.RatePriceEntity;

@Component
public class MapperServiceRatePriceDtoEntityImpl implements MapperService<RatePriceDto, RatePriceEntity> {

	@Override
	public RatePriceDto map(RatePriceEntity ratePriceEntity) {
		RatePriceDto ratePriceDto = new RatePriceDto();
		ratePriceDto.setIdRatePrice(ratePriceEntity.getIdRatePrice());
		ratePriceDto.setPriceRate(ratePriceEntity.getPriceRate());
		ratePriceDto.setStartRate(ratePriceEntity.getStartRatePrice());
		ratePriceDto.setEndRate(ratePriceEntity.getEndRatePrice());
		return ratePriceDto;
	}

	@Override
	public List<RatePriceDto> map(List<RatePriceEntity> ratePriceEntityList) {
		List<RatePriceDto> rentPriceDtoList = new ArrayList<RatePriceDto>();		
		RatePriceEntity ratePriceEntity = new RatePriceEntity();
		Iterator<RatePriceEntity> iterator = ratePriceEntityList.iterator();
		while(iterator.hasNext()){	
			ratePriceEntity = iterator.next();
			RatePriceDto ratePriceDto = new RatePriceDto();
			ratePriceDto.setIdRatePrice(ratePriceEntity.getIdRatePrice());
			ratePriceDto.setPriceRate(ratePriceEntity.getPriceRate());
			ratePriceDto.setStartRate(ratePriceEntity.getStartRatePrice());
			ratePriceDto.setEndRate(ratePriceEntity.getEndRatePrice());
			rentPriceDtoList.add(ratePriceDto);			
		}
		return rentPriceDtoList;
	}

}
