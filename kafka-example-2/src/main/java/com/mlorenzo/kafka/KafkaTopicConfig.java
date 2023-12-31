package com.mlorenzo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaTopicConfig {

    @Bean
    public NewTopic exampleTopic() {
        return TopicBuilder.name("example-topic").build();
    }
}
