package com.mlorenzo.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Opcional
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.mlorenzo.notification","com.mlorenzo.amqp"})
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    // Se comenta porque es para realizar pruebas
    /*@Bean
    public CommandLineRunner runner(RabbitMQMessageProducer producer, RabbitMQProperties rabbitMQProperties) {
        return args -> producer.publish(new Person("Ali", 34), rabbitMQProperties.getExchange(),
                rabbitMQProperties.getRoutingKey());
    }

    record Person(String name, int age) {}*/
}
