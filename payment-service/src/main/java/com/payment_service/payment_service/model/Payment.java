package com.payment_service.payment_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String orderId;
    private String userId;
    private Double amount;
    private String status;
    private LocalDateTime timestamp;

    // Getters and Setters
}