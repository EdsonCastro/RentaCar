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
import com.example.rentacar.dao.CarRepository;
import com.example.rentacar.dto.CarDto;
import com.example.rentacar.model.entitity.CarEntity;
import com.example.rentacar.service.MapperService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarRepository carRepository;	
	@Autowired
	private MapperService<CarDto, CarEntity> mapperServiceDtoEntity;
	@Autowired
	private MapperService<CarEntity, CarDto> mapperServiceEntityDto;
	
	@GetMapping("/findAll")
	public List<CarDto> findAll(){
		List <CarEntity> carEntityList = carRepository.findAll();
		List <CarDto> carDtoList = mapperServiceDtoEntity.map(carEntityList);
		return carDtoList;
	}
	
	@GetMapping("/{id}")
	public CarDto findOne(@PathVariable("id") Integer id){
		CarEntity carEntity = carRepository.getOne(id);
		CarDto carDto = mapperServiceDtoEntity.map(carEntity);
		return carDto;
	}
	
	@PostMapping()
	public CarDto post(@RequestBody CarDto carDto){		
		CarEntity carEntity = mapperServiceEntityDto.map(carDto);
		carRepository.saveAndFlush((CarEntity) carEntity);		
		carDto.setIdCar(carEntity.getIdCar());
		carDto.setLicenseCar(carEntity.getLicenseCar());
		carDto.setNameCar(carEntity.getNameCar());
		carDto.setTypeCar(carEntity.getTypeCar());		
		return carDto;
	}
	
	@PutMapping
	public CarDto put(@RequestBody CarDto carDto){
		CarEntity carEntity = carRepository.getOne(carDto.getIdCar());		
		carEntity.setLicenseCar(carDto.getLicenseCar());
		carEntity.setNameCar(carDto.getNameCar());
		carEntity.setTypeCar(carDto.getTypeCar());
		carRepository.saveAndFlush((CarEntity)carEntity);
		return carDto;
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
