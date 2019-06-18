package com.example.rentacar.entitity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.example.rentacar.dto.CarDto;
import com.example.rentacar.dto.ClientDto;
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
	private LocalDateTime startDate;
	//private String startDate;
	
	//private Date endDate;
	private LocalDateTime endDate;
	//private String endDate;


	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="client_id_client")
	private ClientEntity client;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="car_id_car")
	private CarEntity car;
	

}

