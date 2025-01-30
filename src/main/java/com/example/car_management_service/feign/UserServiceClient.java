package com.example.car_management_service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.car_management_service.dto.UserDto;

@FeignClient(name = "UserManagementService", url = "http://localhost:2025/users") // Replace with actual service name and URL
public interface UserServiceClient {
    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long userId);
}
