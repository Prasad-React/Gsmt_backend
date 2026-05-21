package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    // Register Employee
    public String register(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Created Successfully";
    }

    // Login Employee
    public boolean login(String employeeId, String password) {
        Employee emp = employeeRepo.findByEmployeeId(employeeId);

        return emp != null &&
               emp.getPassword().equals(password);
    }

    // Reset Password
    public boolean resetPassword(String employeeId, String newPassword) {
        Employee emp = employeeRepo.findByEmployeeId(employeeId);

        if (emp == null) {
            return false;
        }

        emp.setPassword(newPassword);
        employeeRepo.save(emp);

        return true;
    }
}