package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "demo-topic";

    @PostMapping
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent to Kafka: " + message;
    }
}
