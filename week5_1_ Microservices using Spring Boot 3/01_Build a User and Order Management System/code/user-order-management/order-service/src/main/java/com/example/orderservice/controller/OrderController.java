package com.example.orderservice.controller;

import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.feign.UserClient;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;
    private final UserClient userClient;

    public OrderController(OrderService service, UserClient userClient) {
        this.service = service;
        this.userClient = userClient;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userClient.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userClient.getUserById(id);
    }
}
