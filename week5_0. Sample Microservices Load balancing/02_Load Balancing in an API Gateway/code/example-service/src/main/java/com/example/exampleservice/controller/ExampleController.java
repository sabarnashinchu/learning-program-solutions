package com.example.exampleservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/loadbalanced/message")
    public String getMessage() {
        return "Response from example-service on port: " + port;
    }
}
