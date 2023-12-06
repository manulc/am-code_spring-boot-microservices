package com.mlorenzo.notification;

import com.mlorenzo.amqp.RabbitMQProperties;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class NotificationConfig {
    private final RabbitMQProperties rabbitMQProperties;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(rabbitMQProperties.getExchange());
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(rabbitMQProperties.getQueue());
    }

    @Bean
    public Binding internalToNotificationBinding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(rabbitMQProperties.getRoutingKey());
    }
}
