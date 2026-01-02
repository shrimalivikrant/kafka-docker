package com.example1.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example1.demo1.Employee;
import com.example1.demo1.event.EmployeeEvent;
import com.example1.demo1.repository.EmployeeRepository;
import com.example1.demo1.service.EmployeeEventProducer;

@RestController
@RequestMapping("/api/employees")
public class Demo1Controller {

    @Autowired
    private EmployeeEventProducer employeeEventProducer;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        
        // Publish event to Kafka
        EmployeeEvent event = new EmployeeEvent(
            savedEmployee.getId(),
            savedEmployee.getName(),
            savedEmployee.getEmail(),
            savedEmployee.getDepartment(),
            savedEmployee.getSalary(),
            "CREATED",
            System.currentTimeMillis()
        );
        employeeEventProducer.sendEmployeeEvent(event);
        
        return ResponseEntity.ok(savedEmployee);
    }

}

