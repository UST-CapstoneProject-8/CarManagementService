package com.example.car_management_service.entity;

import jakarta.persistence.*;
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
	@Column(name = "car_id")
	private Long carId;

	@Column(name = "car_owner_id")
	private Long ownerId;

	@Column(name = "car_make")
	private String make;

	@Column(name = "car_model")
	private String model;

	@Column(name = "car_year")
	private int year;

	@Column(name = "car_mileage")
	private Long mileage;

	@Column(name = "car_report_id")
	private int conditionReportId;

	@Column(name = "car_sale_decision")
	private int saleDecision;

	@Column(name="car_location")
	private String carLocation;

	@Column(name="Owner_count")
	private int TotalNoOfOwners;

}
