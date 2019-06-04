package com.example.rentacar.entitity;


import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@Entity
@Table(name = "RENT")
public class RentEntity {

	public RentEntity(){};
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementRent", strategy = "increment")
	private Integer id;
	
	private Double price;
	
	//private Date startDate;
	private String startDate;
	
	//private Date endDate;
	private String endDate;


	@ManyToOne	(cascade = CascadeType.PERSIST)
	private ClientEntity client;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private CarEntity car;
	

}

