package com.example.Employee_Be.services;

import com.example.Employee_Be.models.AttendanceModel;

import java.util.List;

public interface AttendanceService {

    List<AttendanceModel> getAllData();

    AttendanceModel addData(AttendanceModel attendance);
}
