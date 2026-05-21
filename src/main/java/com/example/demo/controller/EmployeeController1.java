package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee1;
import com.example.demo.service.EmployeeService1;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController1 {

    @Autowired
    private EmployeeService1 service;

    @PostMapping("/register")
    public Employee1 register(@RequestBody Employee1 emp) {
        return service.register(emp);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee1 emp) {
        Employee1 e = service.login(emp.getEmployeeId(), emp.getPassword());

        if (e != null) {
            return ResponseEntity.ok(e);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody Employee1 emp) {
        boolean updated = service.resetPassword(emp.getEmployeeId(), emp.getPassword());

        if (updated) {
            return "Password updated successfully";
        } else {
            return "Employee not found";
        }
    }
}