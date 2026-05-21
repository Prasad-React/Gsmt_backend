package com.example.demo.service;

import com.example.demo.entity.RouteEntity;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoute(RouteEntity route){
        routeRepository.save(route);
        return "Route Added Successfully";
    }
}