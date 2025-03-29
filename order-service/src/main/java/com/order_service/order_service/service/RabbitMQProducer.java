package com.order_service.order_service.service;

import com.order_service.order_service.model.Order;
import com.order_service.order_service.payload.NotificationPayload;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private static final String QUEUE = "notification-queue";
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderNotification(Order order) {
        try {
            String message = "Order placed with ID: " + order.getId() + " by user " + order.getUserId();
            rabbitTemplate.convertAndSend(QUEUE, new NotificationPayload(order.getUserId(), message));
            System.out.println("Notification sent: " + message);
        } catch (Exception e) {
            System.err.println("Failed to send notification: " + e.getMessage());
            // You could also log this with a logging framework like SLF4J
        }
    }
}