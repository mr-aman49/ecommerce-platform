package com.notification_service.notification_service.service;

import com.notification_service.notification_service.model.Notification;
import com.notification_service.notification_service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification saveNotification(Notification notification) {
        try {
            return notificationRepository.save(notification);
        } catch (Exception e) {
            throw new RuntimeException("Error saving notification: " + e.getMessage(), e);
        }
    }

    public List<Notification> getAllNotifications() {
        try {
            return notificationRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving notifications: " + e.getMessage(), e);
        }
    }
}