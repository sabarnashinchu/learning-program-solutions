package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        try {
            testAddCountry();  // Hands-On 7
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }
    }

    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("XY");
        country.setName("Xyland");

        countryService.addCountry(country); // add new country

        Country addedCountry = countryService.findCountryByCode("XY");
        LOGGER.debug("Added Country: {}", addedCountry);

        LOGGER.info("End");
    }
}
