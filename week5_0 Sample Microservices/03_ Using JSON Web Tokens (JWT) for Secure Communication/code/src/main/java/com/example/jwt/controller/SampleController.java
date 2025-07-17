package com.example.jwt.controller;

import com.example.jwt.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestParam String username) {
        String token = jwtTokenProvider.createToken(username);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, authenticated user!");
    }
}