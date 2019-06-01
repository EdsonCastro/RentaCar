package com.example.rentacar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rentacar.entitity.ClientEntity;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

	//@Query ("select c from client c where c.name like ?:1 or ?:1 is null")
	//@Query ("select c from client c where  c.name like ?1") //or %:name% is null")
	List<ClientEntity> findAll();

	Optional<ClientEntity> findByDni(String dni);



	
	
	
	/*//poner bien consulta fixme
	@Query(nativeQuery = true, value = "select c from Client c where c.id_client = id")
	List<ClientEntity> findRentsClient(Integer id);



	/*@Query(nativeQuery = true, value = "select * from client where dni like :dni")
	Optional<ClientEntity> findByDni(
			@Param("dni")String dni);*/






}
