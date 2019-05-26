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

import com.example.rentacar.dao.RentRepository;
import com.example.rentacar.dto.RentDto;
import com.example.rentacar.model.entitity.RentEntity;
import com.example.rentacar.service.MapperService;

@RestController
@RequestMapping("/rent")
public class RentController {

	@Autowired
	private RentRepository rentRepository;	
	@Autowired
	private MapperService<RentDto, RentEntity> mapperServiceDtoEntity;
	@Autowired
	private MapperService<RentEntity, RentDto> mapperServiceEntityDto;
	
	@GetMapping("/findAll")
	public List<RentDto> findAll(){
		List <RentEntity> rentEntityList = rentRepository.findAll();
		List <RentDto> rentDtoList = mapperServiceDtoEntity.map(rentEntityList);
		return rentDtoList;
	}
	
	@GetMapping("/{id}")
	public RentDto findOne(@PathVariable("id") Integer id){
		RentEntity rentEntity = rentRepository.getOne(id);
		RentDto rentDto = mapperServiceDtoEntity.map(rentEntity);
		return rentDto;
	}
	
	@PostMapping()
	public RentDto post(@RequestBody RentDto rentDto){
		RentEntity rentEntity = mapperServiceEntityDto.map(rentDto);
		rentRepository.saveAndFlush((RentEntity) rentEntity);
		rentDto.setPrice(rentEntity.getPriceRent());
		rentDto.setStartRent(rentEntity.getStartRent());
		rentDto.setEndRent(rentEntity.getEndRent());		
		return rentDto;
	}
	
	@PutMapping("/{id}")
	public RentDto put(@RequestBody RentDto rentDto){
		RentEntity rentEntity = rentRepository.getOne(rentDto.getIdRent());
		rentEntity.setPriceRent(rentDto.getPrice());
		rentEntity.setStartRent(rentDto.getStartRent());
		rentEntity.setEndRent(rentDto.getEndRent());				
		rentRepository.saveAndFlush((RentEntity) rentEntity);	
		return rentDto;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		RentEntity rentEntity = rentRepository.getOne(id);
		if (rentEntity == null){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		else{
			rentRepository.delete(rentEntity);
			return new ResponseEntity<String>(HttpStatus.OK);		
		}
	}
	
}
