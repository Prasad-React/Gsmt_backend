package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeGsmtService;

    // Register Employee
    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        return employeeGsmtService.register(employee);
    }

    // Login Employee
    @PostMapping("/login")
    public ResponseEntity<String> loginEmployee(
            @RequestBody Employee employee) {

        boolean isValid = employeeGsmtService.login(
                employee.getEmployeeId(),
                employee.getPassword()
        );

        if (isValid) {
            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest()
                .body("Invalid Credentials");
    }

    // Reset Password
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestBody Map<String, String> request) {

        boolean updated = employeeGsmtService.resetPassword(
                request.get("employeeId"),
                request.get("newPassword")
        );

        if (updated) {
            return ResponseEntity.ok("Password Reset Successful");
        }

        return ResponseEntity.badRequest()
                .body("Employee Not Found");
    }
}