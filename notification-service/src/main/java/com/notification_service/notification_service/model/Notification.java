package com.notification_service.notification_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "notifications")
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures backward compatibility

    @Id
    private String id;
    private String message;
    private String userId;

    // No-args constructor (needed for MongoDB)
    public Notification() {}

    // Parameterized constructor
    public Notification(String message, String userId) {
        this.message = message;
        this.userId = userId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
