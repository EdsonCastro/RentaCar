package com.example.rentacar.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	private MapperService<ClientEntity, ClientDto> mapperServiceClient;



	@GetMapping()
	public List<ClientDto> findAll(@RequestParam (value = "name", required = false) String name){
		return clientService.findAllClients(name)
				.stream()
				.map(mapperServiceClient::mapToDto)
				.collect(Collectors.toList());
	}
	
		
	@GetMapping("/{id}")
	public  ResponseEntity<ClientDto> findOne(@PathVariable("id") Integer id){
		return clientService.findClientId(id)
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
		
	
	@PostMapping()
	public ResponseEntity<ClientDto> post(@RequestBody ClientDto clientDto){
		return clientService.saveClient(mapperServiceClient.mapToEntity(clientDto))
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping 
	public ResponseEntity<?> put(@RequestBody ClientDto clientDto){
		return clientService.updateClient(mapperServiceClient.mapToEntity(clientDto))
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		clientService.deleteClient(id);
		// 		map(ResponseEntity::ok)
		//		.orElse(ResponseEntity.notFound().build());
		return new ResponseEntity<String>(HttpStatus.OK);
	}


	
}
