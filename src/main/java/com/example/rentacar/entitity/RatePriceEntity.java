package com.example.rentacar.entitity;



import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Data
@AllArgsConstructor
@Entity
@Table(name = "RATE_PRICE")
public class RatePriceEntity {

	public RatePriceEntity(){}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="incrementRate", strategy = "increment")
	private Integer id;

	private Integer price;

	private Date startDate;

	private Date endDate;

	private Integer activeRate;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<CarEntity> cars = new TreeSet<>();
	
	
}


