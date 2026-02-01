package com.example2.demo2.service;

import com.example2.demo2.event.EmployeeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeEventConsumer {

    @KafkaListener(topics = "employee-events", groupId = "demo2-consumer-group-v2")
    public void consumeEmployeeEvent(EmployeeEvent event) {
        log.info("=== Received Employee Event ===");
        log.info("Employee ID: {}", event.getEmployeeId());
        log.info("Name: {}", event.getName());
        log.info("Email: {}", event.getEmail());
        log.info("Department: {}", event.getDepartment());
        log.info("Salary: {}", event.getSalary());
        log.info("Action: {}", event.getAction());
        log.info("Timestamp: {}", event.getTimestamp());
        log.info("================================");
        
        // TODO: You can add audit logging, notifications, or other business logic here
        // For now, we're just logging the received event
    }
}