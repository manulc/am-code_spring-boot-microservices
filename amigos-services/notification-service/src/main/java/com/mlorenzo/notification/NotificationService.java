package com.mlorenzo.notification;

import com.mlorenzo.clients.notification.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
