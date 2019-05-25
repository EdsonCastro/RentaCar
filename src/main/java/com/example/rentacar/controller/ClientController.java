package com.example.rentacar.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*@GetMapping
	public List greeting(@RequestParam(name = "name", defaultValue = "")String name){		
		List<ClientEntity> clientsEntity = clientRepository.findAll();
		List<ClientDto> clientsDto = mapperServiceDtoEntity.map(clientsEntity);
		return clientsDto;
	}*/
	
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
	
	@PutMapping("/{id}")
	public ClientDto put(@RequestBody ClientDto clientDto){
		ClientEntity clientEntity = clientRepository.getOne(clientDto.getIdClient());
		clientEntity.setNameClient(clientDto.getNameClient());
		clientRepository.saveAndFlush((ClientEntity) clientEntity);
		clientDto.setIdClient(clientEntity.getIdclient());
		clientDto.setNameClient(clientEntity.getNameClient());			
		return clientDto;
	}
	
	
}
