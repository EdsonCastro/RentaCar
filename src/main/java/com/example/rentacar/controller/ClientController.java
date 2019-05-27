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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.model.entitity.ClientEntity;
import com.example.rentacar.service.MapperService;
import com.example.rentacar.dao.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;	
	@Autowired
	private MapperService<ClientDto, ClientEntity> mapperServiceDtoEntity;
	@Autowired
	private MapperService<ClientEntity, ClientDto> mapperServiceEntityDto;
	
	@GetMapping("/findAll")
	public List<ClientDto> findAll(){
		List <ClientEntity> clientEntityList = clientRepository.findAll();
		List <ClientDto> clientDtoList = mapperServiceDtoEntity.map(clientEntityList);
		return clientDtoList;
	}
	
	@GetMapping("/{id}")
	public ClientDto findOne(@PathVariable("id") Integer id){
		ClientEntity clientEntity = clientRepository.getOne(id);
		ClientDto clientDto = mapperServiceDtoEntity.map(clientEntity);
		return clientDto;
	}
	
	@PostMapping()
	public ClientDto post(@RequestBody ClientDto clientDto){
		ClientEntity clientEntity = mapperServiceEntityDto.map(clientDto);
		clientRepository.saveAndFlush((ClientEntity) clientEntity);
		clientDto.setIdClient(clientEntity.getIdclient());
		clientDto.setNameClient(clientEntity.getNameClient());
		return clientDto;
	}
	
	@PutMapping
	public ClientDto put(@RequestBody ClientDto clientDto){
		ClientEntity clientEntity = clientRepository.getOne(clientDto.getIdClient());
		clientEntity.setNameClient(clientDto.getNameClient());
		clientRepository.saveAndFlush((ClientEntity) clientEntity);		
		return clientDto;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		ClientEntity clientEntity = clientRepository.getOne(id);
		if (clientEntity == null){
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		else{
			clientRepository.delete(clientEntity);
			return new ResponseEntity<String>(HttpStatus.OK);		
		}
	}

	//poner bien para consulta fixme
	@GetMapping("/{id}/Rents")
	public List<ClientDto> findAllRents(@PathVariable("id") Integer id){
		List <ClientEntity> clientEntityList = clientRepository.findRentsClient(id);
		List <ClientDto> clientDtoList = mapperServiceDtoEntity.map(clientEntityList);
		return clientDtoList;
	}	
	
}