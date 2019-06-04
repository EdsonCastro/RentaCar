package com.example.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.rentacar.dto.CarDto;
import com.example.rentacar.services.RatePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	private RatePriceService RatePriceService;

	@Autowired
	private MapperService<RatePriceEntity, RatePriceDto> mapperRentPriceService;

	@GetMapping()
	public List<RatePriceDto> findAll(@RequestParam(value = "name", required = false) String name){
		return RatePriceService.findAll(name)
				.stream()
				.map(mapperRentPriceService::mapToDto)
				.collect( Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RatePriceDto> findOne(@PathVariable("id") Integer id){
		return RatePriceService.findId(id)
			.map(mapperRentPriceService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
}

	
	@PostMapping()
	public ResponseEntity<RatePriceDto>  post(@RequestBody RatePriceDto ratePriceDto){
		return RatePriceService.save(mapperRentPriceService.mapToEntity(ratePriceDto))
				.map(mapperRentPriceService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody RatePriceDto ratePriceDto){
		return RatePriceService.update(mapperRentPriceService.mapToEntity(ratePriceDto))
			.map(mapperRentPriceService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		RatePriceService.delete(id);
		// 		map(ResponseEntity::ok)
		//		.orElse(ResponseEntity.notFound().build());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
