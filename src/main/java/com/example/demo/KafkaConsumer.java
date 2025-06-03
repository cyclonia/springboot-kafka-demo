package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
