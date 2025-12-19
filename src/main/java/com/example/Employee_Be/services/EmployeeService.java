package com.example.Employee_Be.services;

import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.models.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeInitialDto> getEmployeeBasicDetails();

    EmployeeDto findEmployeeByEid(String eid);

    EmployeeDto deleteEmployeeById(String eid);

    //search employee based on id
    EmployeeDto updateEmployeeById(String eid, EmployeeDto employeeDto);

    //for pagination purpose
    /*Page<EmployeeModel> searchEmployeeBasics(String q, int page, int size, String sortBy, Sort.Direction direction);*/

    List<EmployeeInitialDto> searchEmployees(String value);
}
