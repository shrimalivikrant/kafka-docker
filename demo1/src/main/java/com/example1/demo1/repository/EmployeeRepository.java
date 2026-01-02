package com.example1.demo1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example1.demo1.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}