package com.notification_service.notification_service.listener;

import com.notification_service.notification_service.model.Notification;
import com.notification_service.notification_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = "notification-queue")
    public void receiveNotification(NotificationPayload payload) {
        Notification notification = new Notification();
        notification.setMessage(payload.getMessage());
        notification.setUserId(payload.getUserId());
        notificationService.saveNotification(notification);
    }

    public static class NotificationPayload {
        private String userId;
        private String message;

        // Getters and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
