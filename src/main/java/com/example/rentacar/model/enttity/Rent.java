package com.example.rentacar.model.enttity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RENT")
public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RENT")
	private Integer idRent;
	
	@Column(name = "START_RENT")
	private Date startRent;
	
	@Column(name = "END_RENT")
	private Date endRent;
	
	@ManyToOne	
	private Client client;

	@ManyToOne
	private Car car;
	

}

