package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Order createOrder(Order order) {
        return repo.save(order);
    }
}
