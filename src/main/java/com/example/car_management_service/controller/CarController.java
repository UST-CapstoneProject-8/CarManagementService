package com.example.car_management_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.car_management_service.entity.Car;
import com.example.car_management_service.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping()
	public ResponseEntity<List<Car>> getAllCars()
	{
		return new ResponseEntity<List<Car>>(carService.getAllCars(),HttpStatus.OK);
	}
	
	@GetMapping("/{carId}")
	public ResponseEntity<Car> getCarById(@PathVariable Long carId)
	{
		return new ResponseEntity<Car>(carService.getCarById(carId),HttpStatus.OK);
	}
	
	@PostMapping("/addCar")
	public ResponseEntity<Car> addCar(@RequestBody Car newCar)
	{
		return new ResponseEntity<Car>(carService.addCar(newCar),HttpStatus.OK);
	}
	
	@PutMapping("/updateCar")
	public ResponseEntity<Car> updateCar(@RequestBody Car updateCar)
	{
		return new ResponseEntity<Car>(carService.editCar(updateCar),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCar/{carId}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long CarId)
	{
		carService.deleteCar(CarId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
