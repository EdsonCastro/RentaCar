package com.example.rentacar.entitity;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class CarEntity {

	public CarEntity(){}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementCar", strategy = "increment")
	private Integer idCar;

	private String CarPlate;

	private String registrationYear;

	@OneToMany(mappedBy = "car")
	private Set<RentEntity> carRents = new TreeSet<>();
	
	@ManyToMany(mappedBy = "cars", fetch = FetchType.LAZY)
	private Set<RatePriceEntity> ratePrices = new TreeSet<>();

}