package com.example.rabbit_mq_workout.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbit_mq_workout.dto.User;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = { "${rabbitmq.json.queue.name}" })
    public void consumeJson(User user) {
        LOGGER.info(String.format("message sent to consumer -> %s", user.toString()));
    }
}
