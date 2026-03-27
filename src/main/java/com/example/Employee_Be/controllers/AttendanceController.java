package com.example.Employee_Be.controllers;

import com.example.Employee_Be.models.AttendanceModel;
import com.example.Employee_Be.services.AttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Attendance")
@CrossOrigin(origins = {"https://gopikrishna2707.github.io", "http://localhost:4200"})
public class AttendanceController {

    AttendanceService attendanceService;

    @GetMapping("/attendance")
    public List<AttendanceModel> getAllDetails(){
        return attendanceService.getAllData();
    }

    @GetMapping("/add-attendance")
    public AttendanceModel addingModel(@RequestBody AttendanceModel attendance){
        return attendanceService.addData(attendance);
    }
}
