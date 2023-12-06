package com.mlorenzo.notification;

import com.mlorenzo.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("AmigosCode")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
