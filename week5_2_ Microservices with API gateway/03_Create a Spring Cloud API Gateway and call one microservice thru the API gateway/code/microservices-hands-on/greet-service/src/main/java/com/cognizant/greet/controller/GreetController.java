package com.cognizant.greet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @GetMapping("/greet")
    public String sayHello() {
        return "Hello World!!";
    }
}
