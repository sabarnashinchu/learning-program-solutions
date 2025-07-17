package com.example.payment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ThirdPartyApiClient {

    private static final Logger log = LoggerFactory.getLogger(ThirdPartyApiClient.class);
    private final Random random = new Random();

    // Simulate a slow API call with random success/failure
    public String callExternalPaymentGateway(String transactionId) {
        log.info("Calling external payment gateway for transaction: {}", transactionId);
        try {
            // Simulate network latency or processing time
            int latency = random.nextInt(2000); // 0 to 2000 ms
            Thread.sleep(latency);

            // Simulate failure 50% of the time for demonstration
            if (random.nextBoolean()) {
                log.error("Third-party API call failed for transaction: {}", transactionId);
                throw new RuntimeException("Third-party API is unavailable or slow");
            }

            log.info("Third-party API call successful for transaction: {}", transactionId);
            return "Payment processed successfully by third-party for " + transactionId;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Third-party API call interrupted for transaction: {}", transactionId, e);
            throw new RuntimeException("Third-party API call interrupted", e);
        }
    }
}