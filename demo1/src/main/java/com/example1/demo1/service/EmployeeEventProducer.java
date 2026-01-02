package com.example1.demo1.service;

import com.example1.demo1.event.EmployeeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeEventProducer {

    private final KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public EmployeeEventProducer(KafkaTemplate<String, EmployeeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeEvent(EmployeeEvent event) {
        log.info("Publishing employee event: {}", event);
        kafkaTemplate.send(topicName, event.getEmployeeId().toString(), event);
    }
}