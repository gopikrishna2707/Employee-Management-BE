package com.example.Employee_Be.controllers;
import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.models.AttendanceModel;
import com.example.Employee_Be.services.AttendanceService;
import com.example.Employee_Be.services.AttendanceServiceImpl;
import com.example.Employee_Be.services.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Employee")
@Validated
@CrossOrigin(origins = {"https://gopikrishna2707.github.io", "http://localhost:4200"})
public class EmployeeController {

    EmployeeServiceImpl employeeService;
    AttendanceServiceImpl attendanceService;

    public EmployeeController(EmployeeServiceImpl employeeService, AttendanceServiceImpl attendanceService){
        this.employeeService = employeeService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("employees")
    public List<EmployeeDto> getEmployees(){
        System.out.println("controller" + employeeService.getAllEmployees());
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/basic")
    public List<EmployeeInitialDto> getEmployeeBasicDetails(){
        return employeeService.getEmployeeBasicDetails();
    }


    @PostMapping("employees")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDetails){
        return employeeService.addEmployee(employeeDetails);
    }

    @GetMapping("employees/{eid}")
    public EmployeeDto findEmployeeById(@PathVariable String eid){
        return employeeService.findEmployeeByEid(eid);
    }

    @DeleteMapping("employees/{eid}")
    public EmployeeDto deleteEmployeeById(@PathVariable String eid){
        return employeeService.deleteEmployeeById(eid);
    }

    @PutMapping("employees/{eid}")
    public EmployeeDto updateEmployeeByEid(@PathVariable String eid, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployeeById(eid, employeeDto);
    }

    @GetMapping("employees/search/basic/{value}")
    public List<EmployeeInitialDto> getSearchEmployees(@PathVariable("value") String value){
        return employeeService.searchEmployees(value);
    }

    @GetMapping("employees/attendance")
    public List<AttendanceModel> getAllAttendance(){
        return attendanceService.getAllData();
    }
}
