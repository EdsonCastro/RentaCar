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
		ratePriceEntity.setPriceRate(ratePriceDto.getPriceRate());
		ratePriceEntity.setStartRatePrice(ratePriceDto.getStartRate());
		ratePriceEntity.setEndRatePrice(ratePriceDto.getEndRate());				
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
			ratePriceEntity.setPriceRate(ratePriceDto.getPriceRate());
			ratePriceEntity.setStartRatePrice(ratePriceDto.getStartRate());
			ratePriceEntity.setEndRatePrice(ratePriceDto.getEndRate());
			ratePriceEntityList.add(ratePriceEntity);			
		}
		return ratePriceEntityList;
	}

	@Override
	public RatePriceDto mapToDto(RatePriceEntity ratePriceEntity) {
		RatePriceDto ratePriceDto = new RatePriceDto();
		ratePriceDto.setIdRatePrice(ratePriceEntity.getIdRatePrice());
		ratePriceDto.setPriceRate(ratePriceEntity.getPriceRate());
		ratePriceDto.setStartRate(ratePriceEntity.getStartRatePrice());
		ratePriceDto.setEndRate(ratePriceEntity.getEndRatePrice());
		return ratePriceDto;
	}

	@Override
	public List<RatePriceDto> mapToDto(List<RatePriceEntity> ratePriceEntityList) {
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
