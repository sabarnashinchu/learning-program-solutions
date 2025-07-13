package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return Arrays.asList(
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("IN", "India"),
            new Country("JP", "Japan")
        );
    }
}
