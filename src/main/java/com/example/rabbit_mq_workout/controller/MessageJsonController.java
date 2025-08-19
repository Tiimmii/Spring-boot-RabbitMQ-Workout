package com.example.rabbit_mq_workout.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit_mq_workout.dto.User;
import com.example.rabbit_mq_workout.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/vi")
public class MessageJsonController {
    
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer){
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RabbitMQ");
    }
}
