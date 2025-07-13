package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("STARTING SPRING LEARN APPLICATION");
        SpringApplication.run(SpringLearnApplication.class, args);

        displayCountries();

        LOGGER.info("APPLICATION STARTED SUCCESSFULLY");
    }

    public static void displayCountries() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country us = context.getBean("countryUS", Country.class);
        Country de = context.getBean("countryDE", Country.class);
        Country in = context.getBean("countryIN", Country.class);
        Country jp = context.getBean("countryJP", Country.class);

        LOGGER.debug("US : {}", us);
        LOGGER.debug("DE : {}", de);
        LOGGER.debug("IN : {}", in);
        LOGGER.debug("JP : {}", jp);

        LOGGER.info("--- From List ---");

        @SuppressWarnings("unchecked")
        List<Country> countryList = (List<Country>) context.getBean("countryList");

        for (Country c : countryList) {
            LOGGER.debug("Country from list: {}", c);
        }

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }
}
