package com.example.oauthlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class JwtSecureApp {
    public static void main(String[] args) {
        SpringApplication.run(JwtSecureApp.class, args);
    }
}
