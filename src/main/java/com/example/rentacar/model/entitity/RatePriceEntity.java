package com.example.rentacar.model.entitity;



import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RATE_PRICE")
public class RatePriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RATE")
	private Integer idRatePrice;
	
	@Column(name = "PRICE_RATE")
	private Integer priceRate;
	
	@Column(name = "ACTIVE_RATE")
	private Integer activeRate;
	
	@Column(name = "START_RATE")
	private Date startRatePrice;
	
	@Column(name = "END_RATE")
	private Date endRatePrice;
	
	@ManyToMany
	private Set<CarEntity> cars = new TreeSet<>();
	
	
}


