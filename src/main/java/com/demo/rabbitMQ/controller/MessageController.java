package com.demo.rabbitMQ.controller;

import com.demo.rabbitMQ.dto.User;
import com.demo.rabbitMQ.publisher.RabbitMQJsonProducer;
import com.demo.rabbitMQ.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private RabbitMQProducer producer ;

    @Autowired
    private RabbitMQJsonProducer JsonProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }

    @PostMapping("/publish_json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        JsonProducer.sendMessage(user);
        return ResponseEntity.ok("User sent to RabbitMQ");
    }
}
