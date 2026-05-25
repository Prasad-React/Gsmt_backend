package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.repository.AttendanceRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
    
    public List<Attendance> getAllAttendance() {

        return attendanceRepository.findAll();
    }
}