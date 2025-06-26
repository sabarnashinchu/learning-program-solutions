package com.example;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        return new User(id, "Sabarna");
    }
}
