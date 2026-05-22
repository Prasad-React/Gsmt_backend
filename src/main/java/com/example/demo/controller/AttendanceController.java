package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(

            @RequestParam("employeeId") String employeeId,
            @RequestParam("status") String status,
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude,
            @RequestParam("photo") MultipartFile photo

    ) {

        try {

            // Absolute uploads path
            String uploadDir =
                    System.getProperty("user.dir")
                    + File.separator
                    + "uploads";

            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            // File name
            String fileName =
                    System.currentTimeMillis()
                    + "_selfie.jpg";

            // Full path
            File destination =
                    Paths.get(uploadDir, fileName).toFile();

            // Save image
            photo.transferTo(destination);

            // Save DB
            Attendance attendance = new Attendance();

            attendance.setEmployeeId(employeeId);
            attendance.setStatus(status);
            attendance.setLatitude(latitude);
            attendance.setLongitude(longitude);

            attendance.setPhotoPath(fileName);

            Attendance saved =
                    attendanceService.save(attendance);

            return ResponseEntity.ok(saved);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }
}