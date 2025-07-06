package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendersExample {

    private static final Logger logger = LoggerFactory.getLogger(AppendersExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - for developers");
        logger.info("Info message - general information");
        logger.warn("Warning message - something to look at");
        logger.error("Error message - something went wrong");
    }
}
