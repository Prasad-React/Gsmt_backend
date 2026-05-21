package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepo;

    public String markAttendance(Attendance attendance) {
        attendanceRepo.save(attendance);
        return "Attendance Marked Successfully";
    }
}