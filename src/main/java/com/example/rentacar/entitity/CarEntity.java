package com.example.rentacar.entitity;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class CarEntity {

	public CarEntity(){}

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String CarPlate;

	private String registrationYear;

	@OneToMany(mappedBy = "car")
	private Set<RentEntity> carRents = new TreeSet<>();
	
	@ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
	private Set<RatePriceEntity> ratePrices = new TreeSet<>();

}