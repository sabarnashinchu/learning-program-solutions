package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("Demonstrating Singleton Scope");
        demonstrateScope();
    }

    public static void demonstrateScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country1 = context.getBean("country", Country.class);
        Country country2 = context.getBean("country", Country.class);

        LOGGER.info("country1: {}", country1);
        LOGGER.info("country2: {}", country2);

        if (country1 == country2) {
            LOGGER.info("Singleton scope: SAME instance.");
        } else {
            LOGGER.info("Prototype scope: DIFFERENT instances.");
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
