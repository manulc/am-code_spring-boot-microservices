package com.mlorenzo.kafka;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/messages")
public class KafkaMessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void publish(@RequestBody Map<String, String> messageRequest) {
        kafkaTemplate.send("example-topic", messageRequest.get("message"));
    }
}
