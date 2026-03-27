package com.example.Employee_Be.services;

import com.example.Employee_Be.models.AttendanceModel;
import com.example.Employee_Be.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    AttendanceRepository attendanceRepository;

    @Override
    public List<AttendanceModel> getAllData() {
        return attendanceRepository.findAll();
    }

    @Override
    public AttendanceModel addData(AttendanceModel attendance) {
        return attendanceRepository.save(attendance);
    }


}
