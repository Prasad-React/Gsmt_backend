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

            System.out.println("===== ATTENDANCE API CALLED =====");

            // Validation
            if (photo == null || photo.isEmpty()) {

                return ResponseEntity.badRequest()
                        .body("Photo is missing");

            }

            // Render-safe temp directory
            String uploadDir =
                    System.getProperty("java.io.tmpdir")
                    + File.separator
                    + "uploads";

            File dir = new File(uploadDir);

            // Create uploads folder if not exists
            if (!dir.exists()) {

                boolean created = dir.mkdirs();

                System.out.println("Uploads folder created: " + created);
            }

            // Unique file name
            String fileName =
                    System.currentTimeMillis()
                    + "_selfie.jpg";

            // Destination file
            File destination =
                    Paths.get(uploadDir, fileName).toFile();

            System.out.println("Saving image to: "
                    + destination.getAbsolutePath());

            // Save image
            photo.transferTo(destination);

            System.out.println("Image saved successfully");

            // Save attendance data
            Attendance attendance = new Attendance();

            attendance.setEmployeeId(employeeId);
            attendance.setStatus(status);
            attendance.setLatitude(latitude);
            attendance.setLongitude(longitude);
            attendance.setPhotoPath(fileName);

            Attendance saved =
                    attendanceService.save(attendance);

            System.out.println("Attendance saved to DB");

            return ResponseEntity.ok(saved);

        } catch (Exception e) {

            System.out.println("===== ERROR IN ATTENDANCE API =====");

            e.printStackTrace();

            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getMessage());
        }
    }
}