package com.example.rentacar.entitity;


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
public class RentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer price;
	
	private Date startDatet;
	
	private Date endDate;
	
	@ManyToOne	
	private ClientEntity client;

	@ManyToOne
	private CarEntity car;
	

}

