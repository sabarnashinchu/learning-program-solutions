package com.example.demo;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserNotFoundThrowsException() {
        Long fakeId = 100L;

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(fakeId);
        });

        assertEquals("User not found with ID: 100", exception.getMessage());
    }
}
