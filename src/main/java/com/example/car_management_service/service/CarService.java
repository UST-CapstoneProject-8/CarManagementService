package com.example.car_management_service.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.car_management_service.entity.Car;
import com.example.car_management_service.exception.ResourceNotFoundException;
import com.example.car_management_service.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;
	
	private Cloudinary cloudinary;

	public CarService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
	
	public List<Car> getAllCars()
	{
		return carRepo.findAll();
	}
	
	public Car getCarById(Long carId) {
	    return carRepo.findById(carId)
	            .orElseThrow(() -> new ResourceNotFoundException("Car with ID " + carId + " not found"));
	}
	public Car addCar(Car newCar) {
		return carRepo.save(newCar);
	}

	public Car addCarWithImage(Car car, List<MultipartFile> files) throws IOException {
    List<String> carImageUrls = new ArrayList<>();
    
    if (files != null && !files.isEmpty()) {
        for (MultipartFile file : files) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            carImageUrls.add(uploadResult.get("secure_url").toString());
        }
    }
    car.setCarImageUrls(carImageUrls);
    
    return carRepo.save(car);
}
	
//	public Car editCar(Car updateCar)
//	{
//		Optional<Car> existingCar = carRepo.findById(updateCar.getCarId());
//		Car car = existingCar.get();
//		BeanUtils.copyProperties(updateCar, car);
//		return carRepo.save(car);
//	}
	
	public Car editCar(Car updateCar) {
	    Optional<Car> existingCarOptional = carRepo.findById(updateCar.getCarId());
	    
	    if (existingCarOptional.isEmpty()) {
	        throw new ResourceNotFoundException("Car with ID " + updateCar.getCarId() + " not found");
	    }
	    
	    Car existingCar = existingCarOptional.get();
	    
	    // Copy properties, excluding carImageUrls
	    BeanUtils.copyProperties(updateCar, existingCar, "carImageUrls");
	    
	    // Update carImageUrls if provided
	    if (updateCar.getCarImageUrls() != null && !updateCar.getCarImageUrls().isEmpty()) {
	        existingCar.setCarImageUrls(updateCar.getCarImageUrls());
	    }
	    
	    return carRepo.save(existingCar);
	}


	
	public List<Car> getCarsByLocation(String Location)
	{
		return carRepo.findByCarLocation(Location);
	}

	public List<Car> getCarsByOwnerId(Long ownerId)
	{
		return carRepo.findByOwnerId(ownerId);
	}	

	public void deleteCar(Long carId)
	{
		carRepo.deleteById(carId);
	}

}
