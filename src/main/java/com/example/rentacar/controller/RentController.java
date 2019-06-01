package com.example.rentacar.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.rentacar.dao.RentRepository;
import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.dto.RentDto;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.entitity.RentEntity;
import com.example.rentacar.services.RentService;

@RestController
@RequestMapping("/rent")
public class RentController {

	@Autowired
	private RentService rentService;
	
	@Autowired
	private MapperService<RentEntity, RentDto> mapperRentService;

	
	@GetMapping()
	public List<RentDto> findAll(){
		List <RentEntity> rentEntityList = rentService.findAllRents();
		List <RentDto> rentDtoList = mapperRentService.mapToDto(rentEntityList);
		return rentDtoList;
	}
	
	@GetMapping("/{id}")
	public RentDto findOne(@PathVariable("id") Integer id){
		RentDto rentDto = new RentDto();
		Optional<RentEntity> optionalRentEntity = rentService.findRentId(id);			
		if (optionalRentEntity.isPresent())
		{
			RentEntity rentEntity = optionalRentEntity.get(); 
			rentDto = mapperRentService.mapToDto(rentEntity);
		}
		return rentDto;			
	}
	
	
	@PostMapping()
	public ResponseEntity<String> post(@RequestBody RentDto rentDto){
	Optional<RentEntity> optionalRentEntity = rentService.findRentId(rentDto.getId());	
		if (!optionalRentEntity.isPresent())
		{		
			RentEntity rentEntity = new RentEntity();
			rentEntity = mapperRentService.mapToEntity(rentDto);
			rentService.saveRent(rentEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.FOUND);
	}
	
	@PutMapping
	public ResponseEntity<String> put(@RequestBody RentDto rentDto){
	Optional<RentEntity> optionalRentEntity = rentService.findRentId(rentDto.getId());	
		if (!optionalRentEntity.isPresent())
		{		
			RentEntity rentEntity = optionalRentEntity.get();
			rentService.deleteRent(rentEntity);
			rentEntity = mapperRentService.mapToEntity(rentDto);
			rentService.saveRent(rentEntity);	
			return new ResponseEntity<String>(HttpStatus.OK);	
		}		
		else{							
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);			
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
	Optional<RentEntity> optionalRentEntity = rentService.findRentId(id);	
		if (!optionalRentEntity.isPresent())
		{	
			RentEntity rentEntity = optionalRentEntity.get();
			rentService.deleteRent(rentEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
}
