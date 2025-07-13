// src/main/java/com/cognizant/spring_learn/controller/CountryController.java
package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private ApplicationContext context;

    public CountryController() {
        System.out.println("CountryController constructor called...");
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        return (Country) context.getBean("country");
    }
}
