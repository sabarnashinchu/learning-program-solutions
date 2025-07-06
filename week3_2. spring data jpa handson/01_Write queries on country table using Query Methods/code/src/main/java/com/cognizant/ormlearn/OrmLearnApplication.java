package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @PostConstruct
    public void testCountryQueryMethods() {
        LOGGER.info("Start");

        // 1. Contains substring
        List<Country> countriesWithOu = countryService.getCountriesContaining("ou");
        LOGGER.info("Countries containing 'ou':");
        countriesWithOu.forEach(c -> LOGGER.info(c.toString()));

        // 2. Contains substring, sorted
        List<Country> sortedCountriesWithOu = countryService.getCountriesContainingSorted("ou");
        LOGGER.info("Countries containing 'ou' sorted by name:");
        sortedCountriesWithOu.forEach(c -> LOGGER.info(c.toString()));

        // 3. Starting with 'Z'
        List<Country> countriesStartingWithZ = countryService.getCountriesStartingWith("Z");
        LOGGER.info("Countries starting with 'Z':");
        countriesStartingWithZ.forEach(c -> LOGGER.info(c.toString()));

        LOGGER.info("End");
    }
}
