package com.example.Employee_Be.dto;
import java.math.BigDecimal;

public class EmployeeInitialDto {

    private Integer id;
    private String eid;
    private String name;
    private String email;
    private String currentlyWorking;
    private BigDecimal salary;

    public EmployeeInitialDto(Integer id, String eid, String name, String currentlyWorking,
                              String email, BigDecimal salary) {
        this.id = id;
        this.eid = eid;
        this.name = name;
        this.currentlyWorking = currentlyWorking;
        this.email = email;
        this.salary = salary;
    }

    public EmployeeInitialDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
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

    public String getCurrentlyWorking() {
        return currentlyWorking;
    }

    public void setCurrentlyWorking(String currentlyWorking) {
        this.currentlyWorking = currentlyWorking;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeInitialDto{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", currentlyWorking='" + currentlyWorking + '\'' +
                ", salary=" + salary +
                '}';
    }
}
