package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(String username, String password) {
        return adminRepository.findByUsername(username)
                .map(admin -> admin.getPassword().equals(password))
                .orElse(false);
    }

    public String updatePassword(String username, String newPassword) {
        Optional<Admin> admin = adminRepository.findByUsername(username);

        if (admin.isPresent()) {
            Admin existingAdmin = admin.get();
            existingAdmin.setPassword(newPassword);
            adminRepository.save(existingAdmin);

            return "Password changed successfully";
        }

        return "Admin not found";
    }
}