package com.example.Employee_Be.exception;

public class EmployeeException extends RuntimeException {

    public EmployeeException(Long id){
        super("record not found");
    }

    public EmployeeException(String message){
        super(message);
    }
}
