package com.example.car_management_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
		return carRepo.save(newCar);
	}
	
	public Car editCar(Car updateCar)
	{
		Optional<Car> existingCar = carRepo.findById(updateCar.getCarId());
		Car car = existingCar.get();
		BeanUtils.copyProperties(updateCar, car);
		return carRepo.save(car);
	}
	
	public List<Car> getCarsByLocation(String Location)
	{
		return carRepo.findByCarLocation(Location);
	}

	public void deleteCar(Long carId)
	{
		carRepo.deleteById(carId);
	}

}
