package com.example.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.rentacar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentacar.component.MapperService;
import com.example.rentacar.dao.CarRepository;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.entitity.CarEntity;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarRepository carRepository;	
	@Autowired
	private MapperService<CarEntity, CarDto> mapperCarServicey;

	
	@GetMapping()
	public List<CarDto> findAll(@RequestParam(value = "name", required = false) String name){
		return carService.findAll(name)
				.stream()
				.map(mapperCarServicey::mapToDto)
				.collect( Collectors.toList());
	}


	@GetMapping("/{id}")
	public ResponseEntity<CarDto> findOne(@PathVariable("id") Integer id){
		return carService.findId(id)
				.map(mapperCarServicey::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@PostMapping()
	public ResponseEntity<CarDto> post(@RequestBody CarDto carDto){
		return carService.save(mapperCarServicey.mapToEntity(carDto))
				.map(mapperCarServicey::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@PutMapping
	public ResponseEntity<?> put(@RequestBody CarDto carDto){
		return carService.update(mapperCarServicey.mapToEntity(carDto))
				.map(mapperCarServicey::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		CarEntity carEntity = carRepository.getOne(id);
		if (carEntity == null){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		else{
			carRepository.delete(carEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}	
}
