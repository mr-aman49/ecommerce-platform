package com.payment_service.payment_service.controller;

import com.payment_service.payment_service.model.Payment;
import com.payment_service.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment pay(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}
