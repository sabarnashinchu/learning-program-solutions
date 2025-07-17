package com.example.userservice.controller;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return service.saveUser(user);
    }
}
