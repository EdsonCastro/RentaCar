package com.example.rentacar.model.entitity;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CAR")
public class CarEntity {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CAR")
	private Integer idCar;

	@Column(name = "LICENSE_CAR")
	private String licenseCar;

	@Column(name = "NAME_CAR")
	private String nameCar;	
	
	@Column(name = "TYPE_CAR")
	private String typeCar;

	@OneToMany(mappedBy = "car")
	private Set<RentEntity> carRents = new TreeSet<>();
	
	@ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
	private Set<RatePriceEntity> ratePrices = new TreeSet<>();

}