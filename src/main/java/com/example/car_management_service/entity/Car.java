package com.example.car_management_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="car_details")
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long carId;
	
	private Long ownerId;
	
	private String make;
	
	private String model;
	
	private int year;
	
	private Long mileage;
	
	private int conditionReportId;
	
	private int saleDecision;
	
	private String carLocation;
	
	private int TotalNoOfOwners;

}
