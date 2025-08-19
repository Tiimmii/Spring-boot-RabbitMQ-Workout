package com.example.rabbit_mq_workout.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.exchange.name}"})
    public void consume(String message){
        LOGGER.info(String.format("message sent to consumer -> %s", message));
        
    }
}
