package com.example.rentacar.entitity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table (name = "CLIENT")
public class ClientEntity {

	public ClientEntity(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String dni;

	private String name;
	
	@OneToMany(mappedBy = "client")
	private Set<RentEntity> clientsRents = new TreeSet<>();
}
