package com.example.rentacar.model.entitity;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENT")
	private Integer idclient;
	
	@Column(name = "NAME_CLIENT")
	private String nameClient;
	
	@OneToMany(mappedBy = "client")
	private Set<Rent> clientsRents = new TreeSet<>();
	
}
