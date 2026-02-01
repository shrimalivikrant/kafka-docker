package com.example2.demo2.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEvent implements Serializable {
    private Long employeeId;
    private String name;
    private String email;
    private String department;
    private Double salary;
    private String action; // CREATED, UPDATED, DELETED
    private Long timestamp;
}