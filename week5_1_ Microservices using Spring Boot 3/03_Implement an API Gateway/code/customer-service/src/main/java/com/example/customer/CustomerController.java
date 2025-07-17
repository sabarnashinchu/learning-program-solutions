package com.example.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/hello")
    public String helloCustomer() {
        return "Hello from Customer Service!";
    }

    @GetMapping("/test")
    public String testCustomer() {
        return "Test endpoint from Customer Service!";
    }
}