package com.mlorenzo.customer;

import com.mlorenzo.amqp.RabbitMQMessageProducer;
import com.mlorenzo.amqp.RabbitMQProperties;
import com.mlorenzo.clients.fraudcheck.FraudCheckClient;
import com.mlorenzo.clients.fraudcheck.FraudCheckRequest;
import com.mlorenzo.clients.fraudcheck.FraudCheckResponse;
import com.mlorenzo.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        FraudCheckClient fraudCheckClient,
        RabbitMQMessageProducer producer, RabbitMQProperties rabbitMQProperties) implements CustomerService {

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        /*HttpEntity<FraudCheckRequest> httpEntity = new HttpEntity<>(new FraudCheckRequest(savedCustomer.getId()));
        FraudCheckResponse fraudCheckResponse = restTemplate
                .postForObject("http://FRAUD-SERVICE/api/v1/fraud-checks", httpEntity, FraudCheckResponse.class);*/
        FraudCheckResponse fraudCheckResponse = fraudCheckClient.checkIsFraudster(new FraudCheckRequest(savedCustomer.getId()));
        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster())
            throw new IllegalStateException("fraudster");
        NotificationRequest notificationRequest = new NotificationRequest(customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...", customer.getFirstName()));
        /*notificationClient.send(notificationRequest);*/
        producer.publish(notificationRequest, rabbitMQProperties.getExchange(), rabbitMQProperties.getRoutingKey());
    }
}
