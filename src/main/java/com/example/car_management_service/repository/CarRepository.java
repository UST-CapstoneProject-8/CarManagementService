package com.example.car_management_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.car_management_service.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>{
	
	List<Car> findByCarLocation(String location);
	List<Car> findByOwnerId(Long ownerId);
	List<Car> findByMake(String make);
}
