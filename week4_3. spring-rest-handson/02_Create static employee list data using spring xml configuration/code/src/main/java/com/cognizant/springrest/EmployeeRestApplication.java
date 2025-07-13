package com.cognizant.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")
public class EmployeeRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeRestApplication.class, args);
    }
}
