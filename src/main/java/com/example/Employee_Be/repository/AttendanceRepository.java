package com.example.Employee_Be.repository;

import com.example.Employee_Be.models.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceModel, Long> {

}
