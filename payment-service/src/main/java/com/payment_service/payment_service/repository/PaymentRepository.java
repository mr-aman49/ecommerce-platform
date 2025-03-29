package com.payment_service.payment_service.repository;

import com.payment_service.payment_service.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
