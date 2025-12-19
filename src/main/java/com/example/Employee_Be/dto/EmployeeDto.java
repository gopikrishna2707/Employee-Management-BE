package com.example.Employee_Be.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class EmployeeDto {

    @Override
    public String toString() {
        return "EmployeeDto{" +
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

    public EmployeeDto(Integer id, String eid, String name, String email, String department,
                       String designation, String location, String reportingManager,
                       String reportingManagerMail, String joinedDate, String experience,
                       String currentlyWorking, String skills, String personalDetails, BigDecimal salary) {
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
        this.currentlyWorking = currentlyWorking;
        this.skills = skills;
        this.personalDetails = personalDetails;
        this.salary = salary;
    }

    public EmployeeDto() {
    }

    public Integer getId() {
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

    private Integer id;
    private String eid;

    @NotBlank(message = "name cant be null")
    private String name;

    @NotBlank(message = "email cant be null")
    @Email(message = "email should be valid")
    private String email;
    private String department;
    private String designation;

    @NotNull(message = "Salary should be add")
    @Positive(message = "salary should be positive")
    private BigDecimal salary;
    private String location;
    private String reportingManager;
    private String reportingManagerMail;
    private String joinedDate;
    private String experience;
    private String currentlyWorking;

    @NotBlank(message = "skills needs to be added")
    private String skills;
    private String personalDetails;
}
