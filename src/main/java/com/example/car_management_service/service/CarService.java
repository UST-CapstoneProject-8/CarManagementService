package com.example.car_management_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.car_management_service.entity.Car;
import com.example.car_management_service.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;
	
	public List<Car> getAllCars()
	{
		return carRepo.findAll();
	}
	
	public Car getCarById(Long carId)
	{
		return carRepo.findById(carId).orElse(null);
	}
	
	public Car addCar(Car newCar) {
		return carRepo.saveAndFlush(newCar);
	}
	
	public Car editCar(Car updatedCar)
	{
		return carRepo.save(updatedCar);
	}
	
	public void deleteCar(Long carId)
	{
		carRepo.deleteById(carId);
	}

}
