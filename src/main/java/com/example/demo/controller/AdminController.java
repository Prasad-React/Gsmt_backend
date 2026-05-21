package com.example.demo.controller;

import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        boolean success = adminService.login(username, password);

        if (success) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }

    // FORGOT PASSWORD / UPDATE PASSWORD
    @PutMapping("/update-password")
    public String updatePassword(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String newPassword = request.get("password");

        return adminService.updatePassword(username, newPassword);
    }
}