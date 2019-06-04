package com.example.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.rentacar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rentacar.component.MapperService;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.entitity.CarEntity;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private MapperService<CarEntity, CarDto> mapperCarService;

	
	@GetMapping()
	public List<CarDto> findAll(@RequestParam(value = "name", required = false) String name){
		return carService.findAll(name)
				.stream()
				.map(mapperCarService::mapToDto)
				.collect( Collectors.toList());
	}


	@GetMapping("/{id}")
	public ResponseEntity<CarDto> findOne(@PathVariable("id") Integer id){
		return carService.findId(id)
				.map(mapperCarService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@PostMapping()
	public ResponseEntity<CarDto> post(@RequestBody CarDto carDto){
		return carService.save(mapperCarService.mapToEntity(carDto))
				.map(mapperCarService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@PutMapping
	public ResponseEntity<?> put(@RequestBody CarDto carDto){
		return carService.update(mapperCarService.mapToEntity(carDto))
				.map(mapperCarService::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
			carService.delete(id);
			// 		map(ResponseEntity::ok)
			//		.orElse(ResponseEntity.notFound().build());
			return new ResponseEntity<String>(HttpStatus.OK);
		}
}
