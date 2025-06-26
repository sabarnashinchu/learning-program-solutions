package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetUserById() {
        System.out.println("✅ testGetUserById started...");

        // Arrange
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Sabarna");

        when(userService.getUserById(1L)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.getUser(1L);

        // Assert
        System.out.println("Returned Name: " + response.getBody().getName());
        assertEquals("Sabarna", response.getBody().getName());
        assertEquals(1L, response.getBody().getId());

        System.out.println("🎉 testGetUserById passed!");
    }
}
