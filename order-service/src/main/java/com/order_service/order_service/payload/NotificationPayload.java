package com.order_service.order_service.payload;

import java.io.Serializable;

public class NotificationPayload implements Serializable {
    private String userId;
    private String message;

    public NotificationPayload(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

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

    @Override
    public String toString() {
        return "NotificationPayload{" +
                "userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
