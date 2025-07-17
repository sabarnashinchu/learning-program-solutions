package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = repository.findById(id).orElseThrow();
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserDTO saveUser(User user) {
        User saved = repository.save(user);
        return new UserDTO(saved.getId(), saved.getName(), saved.getEmail());
    }
}
