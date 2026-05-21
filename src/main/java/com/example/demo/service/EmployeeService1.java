package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee1;
import com.example.demo.repository.EmployeeRepository1;

import java.util.Optional;
import java.util.Random;

@Service
public class EmployeeService1 {

    @Autowired
    private EmployeeRepository1 repo;

    public Employee1 register(Employee1 emp) {
        emp.setEmployeeId(generateEmpId());
        return repo.save(emp);
    }

    public Employee1 login(String empId, String password) {
        return repo.findByEmployeeIdAndPassword(empId, password)
                   .orElse(null);
    }
    
    public boolean resetPassword(String empId, String newPassword) {
        Optional<Employee1> empOpt = repo.findByEmployeeId(empId);

        if (empOpt.isPresent()) {
            Employee1 emp = empOpt.get();
            emp.setPassword(newPassword);
            repo.save(emp);
            return true;
        }
        return false;
    }

    private String generateEmpId() {
        return "EMP" + (1000 + new Random().nextInt(9000));
    }
}