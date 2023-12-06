package com.mlorenzo.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification-service")
public interface NotificationClient {

    @PostMapping("api/v1/notifications")
    void send(NotificationRequest notificationRequest);
}
