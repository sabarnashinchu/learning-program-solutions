package com.example.billing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingController {

    @GetMapping("/hello")
    public String helloBilling() {
        return "Hello from Billing Service!";
    }

    @GetMapping("/test")
    public String testBilling() {
        return "Test endpoint from Billing Service!";
    }
}