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
        // Load Spring context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

        // Get the SimpleDateFormat bean
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        String dateString = "31/12/2018";
        try {
            // Parse the date string
            Date parsedDate = format.parse(dateString);
            System.out.println("Parsed Date: " + parsedDate);

            // If you also want today's date formatted:
            Date today = new Date();
            System.out.println("Today’s Date: " + format.format(today));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
