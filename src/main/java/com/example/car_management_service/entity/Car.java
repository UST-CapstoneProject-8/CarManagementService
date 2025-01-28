package com.example.car_management_service.entity;

import java.util.List;

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

	public void setmake(String make) {
        this.make = make.toUpperCase();
    }

	@Column(name = "car_model")
	private String model;

	public void setmodel(String model) {
        this.model = model.toUpperCase();
    }

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

	public void setCarLocation(String carLocation) {
        this.carLocation = carLocation.toUpperCase();
    }


	@Column(name="Owner_count")
	private int TotalNoOfOwners;
	
	@Enumerated(EnumType.STRING)
    private Status status;
	

	@ElementCollection
    @CollectionTable(name = "car_images", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "car_image_url")
    private List<String> carImageUrls;
	
	

	
}
