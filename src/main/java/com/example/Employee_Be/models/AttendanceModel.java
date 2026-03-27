package com.example.Employee_Be.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "attendance")
@Data
public class AttendanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AttendanceModel(Long id, String eid, LocalDateTime loggedIn, LocalDateTime loggedOut, String workingHours, Long workedInMonth, boolean isCompliance) {
        this.id = id;
        this.eid = eid;
        this.loggedIn = loggedIn;
        this.loggedOut = loggedOut;
        this.workingHours = workingHours;
        this.workedInMonth = workedInMonth;
        this.isCompliance = isCompliance;
    }

    private String eid;
    private LocalDateTime loggedIn;
    private LocalDateTime loggedOut;
    private String workingHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public LocalDateTime getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(LocalDateTime loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LocalDateTime getLoggedOut() {
        return loggedOut;
    }

    public void setLoggedOut(LocalDateTime loggedOut) {
        this.loggedOut = loggedOut;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Long getWorkedInMonth() {
        return workedInMonth;
    }

    public void setWorkedInMonth(Long workedInMonth) {
        this.workedInMonth = workedInMonth;
    }

    public boolean isCompliance() {
        return isCompliance;
    }

    public void setCompliance(boolean compliance) {
        isCompliance = compliance;
    }

    private Long workedInMonth;
    private boolean isCompliance;
}
