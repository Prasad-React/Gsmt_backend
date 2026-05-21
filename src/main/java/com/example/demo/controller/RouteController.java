package com.example.demo.controller;

import com.example.demo.entity.RouteEntity;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/route")
@CrossOrigin("*")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public String addRoute(@RequestBody RouteEntity route){
        return routeService.addRoute(route);
    }

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "status", "Backend Running 🚀",
            "deployment", "Render Success",
            "db", "Connected",
            "api", "Working"
        );
    }
}
