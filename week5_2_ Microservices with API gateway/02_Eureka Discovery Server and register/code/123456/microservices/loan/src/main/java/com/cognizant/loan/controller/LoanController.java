package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        return Map.of(
                "number", number,
                "type", "car",
                "loan", 400000,
                "emi", 3258,
                "tenure", 18
        );
    }
}
