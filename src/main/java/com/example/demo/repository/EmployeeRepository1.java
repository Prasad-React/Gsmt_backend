package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Employee1;

import java.util.Optional;

public interface EmployeeRepository1 extends JpaRepository<Employee1, String> {

    Optional<Employee1> findByEmployeeId(String employeeId);

    Optional<Employee1> findByEmployeeIdAndPassword(String employeeId, String password);
}