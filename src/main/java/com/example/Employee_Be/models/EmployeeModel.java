package com.example.Employee_Be.models;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "Employees")
public class EmployeeModel {
    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                ", reportingManager='" + reportingManager + '\'' +
                ", reportingManagerMail='" + reportingManagerMail + '\'' +
                ", joinedDate='" + joinedDate + '\'' +
                ", experience='" + experience + '\'' +
                ", currentlyWorking='" + currentlyWorking + '\'' +
                ", skills='" + skills + '\'' +
                ", personalDetails='" + personalDetails + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public String getReportingManagerMail() {
        return reportingManagerMail;
    }

    public void setReportingManagerMail(String reportingManagerMail) {
        this.reportingManagerMail = reportingManagerMail;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCurrentlyWorking() {
        return currentlyWorking;
    }

    public void setCurrentlyWorking(String currentlyWorking) {
        this.currentlyWorking = currentlyWorking;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eid;
    private String name;
    private String email;
    private String department;
    private String designation;
    private BigDecimal salary;
    private String location;
    private String reportingManager;
    private String reportingManagerMail;
    private String joinedDate;
    private String experience;
    private String currentlyWorking;
    private String skills;
    private String personalDetails;


    public EmployeeModel(Integer id, String name, String email, String department, String designation,
                         String location, String reportingManager, String reportingManagerMail,
                         String joinedDate, String experience, String skills, String currentlyWorking,
                         String personalDetails, String eid, BigDecimal salary) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.location = location;
        this.reportingManager = reportingManager;
        this.reportingManagerMail = reportingManagerMail;
        this.joinedDate = joinedDate;
        this.experience = experience;
        this.skills = skills;
        this.currentlyWorking = currentlyWorking;
        this.personalDetails = personalDetails;
        this.salary = salary;
    }

    public EmployeeModel() {
    }


    @PrePersist
    public void generateEid() {
        if (this.eid == null) {
            this.eid = UUID.randomUUID().toString();
        }
    }
}
