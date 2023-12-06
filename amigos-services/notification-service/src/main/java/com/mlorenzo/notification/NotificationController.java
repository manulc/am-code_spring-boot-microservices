package com.mlorenzo.notification;

import com.mlorenzo.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification: {}", notificationRequest);
        notificationService.send(notificationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
