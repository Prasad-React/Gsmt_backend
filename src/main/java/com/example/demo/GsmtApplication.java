package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.entity")   // ✅ ADD THIS
@EnableJpaRepositories(basePackages = "com.example.demo.repository") // ✅ ADD THIS
public class GsmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsmtApplication.class, args);
    }
}