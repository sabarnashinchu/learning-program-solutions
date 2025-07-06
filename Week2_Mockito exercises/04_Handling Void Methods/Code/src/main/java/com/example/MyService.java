package com.example;

public class MyService {
    private final LoggerService logger;

    public MyService(LoggerService logger) {
        this.logger = logger;
    }

    public void doSomethingImportant() {
        // Call the void method
        logger.log("Important action done!");
    }
}
