package com.example.rentacar.entitity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@Entity
@Table (name = "CLIENT")
public class ClientEntity {

	public ClientEntity(){}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementClient", strategy = "increment")
	private Integer idClient;

	private String dni;

	private String name;

	@OneToMany(mappedBy = "client")
	private Set<RentEntity> clientsRents = new TreeSet<>();
}
