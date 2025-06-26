package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionLoggingExample.class);

    public static void main(String[] args) {
        logger.info("Starting the exception logging example...");

        try {
            int result = divide(10, 0); // This will cause ArithmeticException
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("An error occurred during division", e);  // Logging with stack trace
        }

        logger.info("Program finished.");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
