package com.example.dummybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DummyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyBackendApplication.class, args);
    }

    @GetMapping("/dummy/test")
    public String test(@RequestParam(name = "fail", required = false, defaultValue = "false") boolean fail) {
        if (fail) {
            throw new RuntimeException("Simulated failure");
        }
        return "Response from dummy backend";
    }
}