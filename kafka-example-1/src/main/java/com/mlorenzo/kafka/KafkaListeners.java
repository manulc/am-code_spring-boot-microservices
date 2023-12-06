package com.mlorenzo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "example-topic", groupId = "group-1")
    private void listener(String message) {
        System.out.println("Listener received: " + message);
    }
}
