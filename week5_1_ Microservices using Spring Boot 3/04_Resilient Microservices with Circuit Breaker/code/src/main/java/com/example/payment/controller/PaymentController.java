package com.example.payment.controller;

import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/process/{transactionId}")
    public ResponseEntity<String> processPayment(@PathVariable String transactionId) {
        String result = paymentService.processPayment(transactionId);
        return ResponseEntity.ok(result);
    }
}