package com.payment_service.payment_service.service;

import com.payment_service.payment_service.model.Payment;
import com.payment_service.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setStatus("PAID");
        payment.setTimestamp(LocalDateTime.now());
        return paymentRepository.save(payment);
    }
}
