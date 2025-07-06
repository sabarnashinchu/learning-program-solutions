package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testUpdateCountry();
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");

        countryService.updateCountry("XY", "NewXyland");

        Country updatedCountry = countryService.findCountryByCode("XY");
        LOGGER.debug("Updated Country: {}", updatedCountry);

        LOGGER.info("End");
    }
}
