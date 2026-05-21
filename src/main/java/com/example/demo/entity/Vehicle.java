package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="vehicles_gsmt")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNo;
    private String driverName;

    public Long getId() { return id; }

    public String getVehicleNo() { return vehicleNo; }
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}