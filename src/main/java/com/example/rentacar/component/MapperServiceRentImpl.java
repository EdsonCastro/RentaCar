package com.example.rentacar.component;

import com.example.rentacar.dto.CarDto;
import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.dto.RentDto;
import com.example.rentacar.entitity.CarEntity;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.RentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class MapperServiceRentImpl implements MapperService<RentEntity, RentDto>{

	@Autowired
	private MapperService<CarEntity, CarDto> mapperCarService;

	@Autowired
	private MapperService<ClientEntity, ClientDto> mapperServiceClient;

	@Override
	public RentEntity mapToEntity(RentDto rentDto) {
			RentEntity rentEntity = new RentEntity();

			rentEntity.setCar(rentDto.getCar());
			rentEntity.setClient(rentDto.getClient());
			rentEntity.setPrice( rentDto.getPrice() );
			rentEntity.setStartDate( rentDto.getStartDate( ));
			rentEntity.setEndDate( rentDto.getEndDate() );
		System.out.println("Entra en mapToEntity de Rent."+rentEntity.getCar());
		return rentEntity;
	}

	@Override
	public List<RentEntity> mapToEntity(List<RentDto> rentDtoList) {
		List<RentEntity> rentEntityList = new ArrayList<RentEntity>();
		RentDto rentDto = new RentDto();
		Iterator<RentDto> iterator = rentDtoList.iterator();
		rentDto = iterator.next();
		while(iterator.hasNext()){
			rentDto = iterator.next();
			RentEntity rentEntity = new RentEntity();
			rentEntity.setCar(rentDto.getCar());
			rentEntity.setClient(rentDto.getClient());
			rentEntity.setPrice( rentDto.getPrice() );
			rentEntity.setStartDate( rentDto.getStartDate( ));
			rentEntity.setEndDate( rentDto.getEndDate() );
			rentEntityList.add(rentEntity);
		}
		System.out.println("Entra en mapToEntity de Rent.");
		return rentEntityList;
	}

	@Override
	public RentDto mapToDto(RentEntity rentEntity) {
		RentDto rentDto = new RentDto(rentEntity.getId(),rentEntity.getCar(), rentEntity.getClient(), rentEntity.getPrice(), rentEntity.getStartDate(), rentEntity.getEndDate());
		return rentDto;
	}

	@Override
	public List<RentDto> mapToDto(List<RentEntity> rentEntityList) {
		List<RentDto> rentDtoList = new ArrayList<RentDto>();
		rentEntityList.forEach(item->{
			rentDtoList.add(new RentDto(item.getId(),item.getCar(), item.getClient(), item.getPrice(), item.getStartDate(), item.getEndDate()));
		});
		return rentDtoList;
	}

}
