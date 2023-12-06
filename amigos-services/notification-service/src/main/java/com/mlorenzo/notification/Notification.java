package com.mlorenzo.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
    private Integer id;

    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
