package com.example.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.component.MapperService;
import com.example.rentacar.dao.RatePriceRepository;
import com.example.rentacar.dao.RentRepository;
import com.example.rentacar.dto.RatePriceDto;
import com.example.rentacar.dto.RentDto;
import com.example.rentacar.entitity.RatePriceEntity;
import com.example.rentacar.entitity.RentEntity;

@RestController
@RequestMapping("/rateprice")
public class RatePriceController {

	@Autowired
	private RatePriceRepository ratePriceRepository;
	@Autowired
	private MapperService<RatePriceDto, RatePriceEntity> mapperServiceDtoEntity;
	@Autowired
	private MapperService<RatePriceEntity, RatePriceDto> mapperServiceEntityDto;
	
	@GetMapping("/findAll")
	public List<RatePriceDto> findAll(){
		List <RatePriceEntity> ratePriceEntityList = ratePriceRepository.findAll();
		List <RatePriceDto> ratePriceDtoList = mapperServiceDtoEntity.map(ratePriceEntityList);
		return ratePriceDtoList;
	}
	
	@GetMapping("/{id}")
	public RatePriceDto findOne(@PathVariable("id") Integer id){
		RatePriceEntity ratePriceEntity = ratePriceRepository.getOne(id);
		RatePriceDto ratePriceDto = mapperServiceDtoEntity.map(ratePriceEntity);
		return ratePriceDto;
	}
	
	//Pendiente agregar la relacion con car y la tabla intermedia.
	@PostMapping()
	public RatePriceDto post(@RequestBody RatePriceDto ratePriceDto){
		RatePriceEntity ratePriceEntity = mapperServiceEntityDto.map(ratePriceDto);
		ratePriceRepository.saveAndFlush((RatePriceEntity) ratePriceEntity);
		ratePriceDto.setIdRatePrice(ratePriceEntity.getIdRatePrice());
		ratePriceDto.setPriceRate(ratePriceEntity.getPriceRate());
		ratePriceDto.setStartRate(ratePriceEntity.getStartRatePrice());
		ratePriceDto.setEndRate(ratePriceEntity.getEndRatePrice());
		return ratePriceDto;
	}
	
	
	
	@PutMapping
	public RatePriceDto put(@RequestBody RatePriceDto ratePriceDto){
		RatePriceEntity ratePriceEntity = ratePriceRepository.getOne(ratePriceDto.getIdRatePrice());
		ratePriceEntity.setPriceRate(ratePriceDto.getPriceRate());
		ratePriceEntity.setStartRatePrice(ratePriceDto.getStartRate());
		ratePriceEntity.setEndRatePrice(ratePriceDto.getEndRate());				
		ratePriceRepository.saveAndFlush((RatePriceEntity) ratePriceEntity);	
		return ratePriceDto;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		RatePriceEntity ratePriceEntity = ratePriceRepository.getOne(id);
		if (ratePriceEntity == null){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		else{
			ratePriceRepository.delete(ratePriceEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}
	
}
