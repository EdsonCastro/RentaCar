package com.example.rentacar.model.enttity;



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
public class RatePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RATEP_RICE")
	private Integer idRatePrice;
	
	@Column(name = "START_RATE_PRICE")
	private Date startRatePrice;
	
	@Column(name = "END_RATE_PRICE")
	private Date endRatePrice;
	
	@ManyToMany
	private Set<Car> ratePriceCars = new TreeSet<>();
	
	
}


