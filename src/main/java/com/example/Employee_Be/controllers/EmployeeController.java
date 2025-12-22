package com.example.Employee_Be.controllers;
import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.services.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://gopikrishna2707.github.io/Employee-Management---FE/")
public class EmployeeController {

    EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
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

    //for pagination
   /* @GetMapping("employees/search-basic/{q}")
    public Page<EmployeeModel> searchEmployeeBasic(
            @PathVariable("q") String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
    ) {
        int safeSize = Math.min(Math.max(size, 1), 100);
        return employeeService.searchEmployeeBasics(q, page, safeSize, sortBy, direction);
    }*/
}
