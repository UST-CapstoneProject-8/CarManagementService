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
	
	public Car getCarById(Long carId)
	{
		return carRepo.findById(carId).orElse(null);
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
    
    // Set the list of image URLs to your product
    car.setCarImageUrls(carImageUrls);
    
    return carRepo.save(car);
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

	public List<Car> getCarsByOwnerId(Long ownerId)
	{
		return carRepo.findByOwnerId(ownerId);
	}	

	public void deleteCar(Long carId)
	{
		carRepo.deleteById(carId);
	}

}
