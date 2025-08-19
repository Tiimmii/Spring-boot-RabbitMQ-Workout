package com.example.rabbit_mq_workout.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbit_mq_workout.dto.User;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.json.exchange.name}")
    private String jsonExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(jsonExchange, jsonRoutingKey, user);
    }
}
