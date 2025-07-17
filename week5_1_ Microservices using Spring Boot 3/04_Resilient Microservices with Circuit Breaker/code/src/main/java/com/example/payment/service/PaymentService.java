package com.example.payment.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private ThirdPartyApiClient thirdPartyApiClient;

    private static final String PAYMENT_SERVICE = "thirdPartyPaymentService"; // Matches name in application.properties

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "processPaymentFallback")
    public String processPayment(String transactionId) {
        log.info("Attempting to process payment for transaction: {}", transactionId);
        return thirdPartyApiClient.callExternalPaymentGateway(transactionId);
    }

    // Fallback method must have the same signature as the original method, plus a Throwable parameter
    public String processPaymentFallback(String transactionId, Throwable t) {
        log.warn("Fallback triggered for transaction: {}. Reason: {}", transactionId, t.getMessage());
        // Log the fallback event specifically for monitoring
        logFallbackEvent(transactionId, t.getClass().getSimpleName(), t.getMessage());
        return "Payment processing failed. Falling back to alternative method. Please try again later. (Transaction ID: " + transactionId + ")";
    }

    private void logFallbackEvent(String transactionId, String exceptionType, String errorMessage) {
        // Here you would typically send this event to a monitoring system (e.g., Prometheus, Grafana, ELK stack)
        // For demonstration, we'll just log it.
        log.error("!!!!! FALLBACK EVENT DETECTED !!!!! TransactionId: {}, ExceptionType: {}, ErrorMessage: {}",
                transactionId, exceptionType, errorMessage);
    }
}