package com.example.orderservice.feign;

import com.example.orderservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
