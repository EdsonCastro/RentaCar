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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.dto.ClientDto;
import com.example.rentacar.entitity.ClientEntity;
import com.example.rentacar.services.ClientService;
import com.example.rentacar.component.MapperService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private MapperService<ClientDto, ClientEntity> mapperServiceDtoEntity;	
	@Autowired
	private MapperService<ClientEntity, ClientDto> mapperServiceEntityDto;
		
	
	@GetMapping()
	public List<ClientDto> findAll(@RequestParam (value = "name", required = false) String name){
		
		if (name.isEmpty()){
			return mapperServiceDtoEntity.map(clientService.findAllClients());
		}
		else{
			return mapperServiceDtoEntity.map(clientService.findClientName(name));
		}
	}
	
		
	@GetMapping("/{id}")
	public ClientDto findOne(@PathVariable("id") Integer id){	
			ClientDto clientDto = new ClientDto();
			Optional<ClientEntity> optionalClientEntity = clientService.findClientId(id);			
			if (optionalClientEntity.isPresent())
			{
				ClientEntity clientEntity = optionalClientEntity.get(); 
				clientDto = mapperServiceDtoEntity.map(clientEntity);
			}
			return clientDto;			
	}
		
	
	@PostMapping()
	public ResponseEntity<String> post(@RequestBody ClientDto clientDto){					
		Optional<ClientEntity> optionalClientEntity = clientService.findClientDni(clientDto.getDni());	
		if (!optionalClientEntity.isPresent())
		{		
			ClientEntity clientEntity = new ClientEntity();
			clientEntity = mapperServiceEntityDto.map(clientDto);
			clientService.saveClient(clientEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.FOUND);
	}
	
	
	@PutMapping 
	public ResponseEntity<String> put(@RequestBody ClientDto clientDto){
		Optional<ClientEntity> optionalClientId = clientService.findClientId(clientDto.getId());
		if (optionalClientId.isPresent())
		{
			ClientEntity clientEntity = optionalClientId.get();
			clientService.deleteClient(clientEntity);
			clientEntity = mapperServiceEntityDto.map(clientDto);
			clientService.saveClient(clientEntity);	
			return new ResponseEntity<String>(HttpStatus.OK);	
		}		
		else{							
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);			
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		Optional<ClientEntity> optionalClientEntity = clientService.findClientId(id);
		if (optionalClientEntity.isPresent())
		{	
			ClientEntity clientEntity = optionalClientEntity.get();
			clientService.deleteClient(clientEntity);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	
}
