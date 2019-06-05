package com.example.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rentacar.component.MapperService;
import com.example.rentacar.dto.RentDto;
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
	public List<RentDto> findAll(@RequestParam(value = "name", required = false) String name){
		return rentService.findAll(name)
				.stream()
				.map(mapperRentService::mapToDto)
				.collect( Collectors.toList());
	}


	@GetMapping("/{id}")
	public  ResponseEntity<RentDto> findOne(@PathVariable("id") Integer id){
		return rentService.findId(id)
			.map(mapperRentService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
}

	
	@PostMapping()
	public ResponseEntity<RentDto> post(@RequestBody RentDto rentDto){

		System.out.println("miau: "+rentDto.getCar()+" miau" );
		System.out.println("miau: "+rentDto.getClient()+" miau" );
		return rentService.save(mapperRentService.mapToEntity(rentDto))
				.map(mapperRentService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody RentDto rentDto){
		return rentService.update(mapperRentService.mapToEntity(rentDto))
				.map(mapperRentService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		rentService.delete(id);
		// 		map(ResponseEntity::ok)
		//		.orElse(ResponseEntity.notFound().build());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
