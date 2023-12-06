package com.mlorenzo.kafka;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("api/v1/messages")
public class KafkaMessageController {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public KafkaMessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void publish(@RequestBody Map<String, String> messageRequest) {
        Message message = new Message(messageRequest.get("message"), LocalDateTime.now());
        kafkaTemplate.send("example-topic", message);
    }
}
