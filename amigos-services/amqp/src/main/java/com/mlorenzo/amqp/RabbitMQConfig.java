package com.mlorenzo.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class RabbitMQConfig {
    //private final ConnectionFactory connectionFactory;

    // Se comenta porque es opcional, es decir, podemos usar la configuración por defecto de "AmqpTemplate".
    // Permite enviar mensajes a RabbitMQ
    /*@Bean
    public AmqpTemplate amqpTemplate(MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }*/

    // Se comenta porque es opcional, es decir, podemos usar la configuración por defecto de
    // "SimpleRabbitListenerContainerFactory".
    // Permite recibir mensajes de RabbitMQ
    /*@Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(MessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }*/

    // Permite serializar y deserializar los mensajes usando JSON
    @Bean
    public MessageConverter jacksonConverter() {
        return new Jackson2JsonMessageConverter();
    }

}