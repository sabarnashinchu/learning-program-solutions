package com.example.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${spring.security.jwt.secret}")
    private String secret;

    public String getSecret() {
        return secret;
    }
}
