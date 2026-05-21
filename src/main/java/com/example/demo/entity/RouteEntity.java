package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destination;

    public Long getId() { return id; }

    public String getSource() { return source; }
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() { return destination; }
    public void setDestination(String destination) {
        this.destination = destination;
    }
}