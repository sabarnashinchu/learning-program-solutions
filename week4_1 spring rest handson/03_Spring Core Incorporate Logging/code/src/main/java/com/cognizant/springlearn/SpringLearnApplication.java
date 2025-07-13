package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        LOGGER.info("STARTING SPRING LEARN APPLICATION");
        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();

        LOGGER.info("APPLICATION STARTED SUCCESSFULLY");
    }

    public static void displayDate() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        String dateString = "31/12/2018";
        try {
            Date parsedDate = format.parse(dateString);
            LOGGER.debug("Parsed Date: {}", parsedDate);

            Date today = new Date();
            LOGGER.debug("Today’s Date: {}", format.format(today));

        } catch (ParseException e) {
            LOGGER.error("Error parsing date", e);
        }

        ((ClassPathXmlApplicationContext) context).close();

        LOGGER.info("END");
    }
}
