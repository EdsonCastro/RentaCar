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
		

	//FIX
	@GetMapping()
	public List<ClientDto> findAll(@RequestParam (value = "name", required = false) String name){

			//FIX PARA TODOS LOS NOMBRES
		return clientService.findAllClients(name)
				.stream()
				.map(mapperServiceClient::mapToDto)
				.collect(Collectors.toList());
	}
	
		
	@GetMapping("/{id}")
	public  ResponseEntity<?> findOne(@PathVariable("id") Integer id){
		return clientService.findClientId(id)
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
		
	
	@PostMapping()
	public ResponseEntity<?> post(@RequestBody ClientDto clientDto){

		return clientService.saveClient(mapperServiceClient.mapToEntity(clientDto))
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping 
	public ResponseEntity<String> put(@RequestBody ClientDto clientDto){

		return clientService.updateClient(mapperServiceClient.mapToEntity(clientDto))
				.map(mapperServiceClient::mapToDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

		/*Optional<ClientEntity> optionalClientId = clientService.findClientId(clientDto.getId());
		if (optionalClientId.isPresent())
		{
			ClientEntity clientEntity = optionalClientId.get();
			clientService.updateClient(clientEntity, clientDto);	
			return new ResponseEntity<String>(HttpStatus.OK);	
		}		
		else{							
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);			
		}*/
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
