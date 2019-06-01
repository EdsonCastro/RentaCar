package com.example.rentacar.entitity;



import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "RATE_PRICE")
public class RatePriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRatePrice;

	private Integer priceRate;

	private Date startRatePrice;

	private Date endRatePrice;

	private Integer activeRate;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<CarEntity> cars = new TreeSet<>();
	
	
}


