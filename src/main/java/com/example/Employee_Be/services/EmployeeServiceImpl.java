package com.example.Employee_Be.services;
import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.exception.EmployeeException;
import com.example.Employee_Be.mapper.EmployeeMapper;
import com.example.Employee_Be.models.EmployeeModel;
import com.example.Employee_Be.repository.AttendanceRepository;
import com.example.Employee_Be.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Injecting employeeRepository
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    AttendanceRepository attendanceRepository;


    //injecting beans of repos
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, AttendanceRepository attendanceRepository){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.attendanceRepository = attendanceRepository;
    }

    //get all employees
    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<EmployeeModel> employeeList = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        System.out.println("service" + employeeList);

        if(employeeList.isEmpty()){
            throw new EmployeeException("No records found");
        }
        return employeeMapper.toEmployeeList(employeeList);
    }

    //Add new Employee
    @Transactional
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        if(employeeRepository.existsByEmail(employeeDto.getEmail())){
            throw new EmployeeException(("email already exist, Please try a new email"));
        }

        EmployeeModel entity = employeeMapper.toEntity(employeeDto);

        EmployeeModel savingDetails = employeeRepository.save(entity);



        return employeeMapper.toDto(savingDetails);
    }

    @Override
    public List<EmployeeInitialDto> getEmployeeBasicDetails() {
        List<EmployeeModel> employeeDtoList = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return employeeMapper.toInitialDto(employeeDtoList);
    }

    @Override
    public EmployeeDto findEmployeeByEid(String eid) {
        return employeeRepository.findByEid(eid)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new EmployeeException(eid));
    }

    @Override
    @Transactional
    public EmployeeDto deleteEmployeeById(String eid) {
        EmployeeModel employee = employeeRepository.findByEid(eid)
                .orElseThrow(() -> new EmployeeException("Employee not found"));

        employeeRepository.deleteByEid(eid);

        return employeeMapper.toDto(employee);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployeeById(String eid, EmployeeDto dto) {
        EmployeeModel employeeModel = employeeRepository.findByEid(eid)
                .orElseThrow(() -> new EmployeeException("Not found the id"));

        if(dto.getCurrentlyWorking().isEmpty()){
            throw new EmployeeException("employee current working is mandatory");
        }

        employeeMapper.updateEmployeeDetailsFromDto(dto, employeeModel);

        EmployeeModel updatedEmployee = employeeRepository.save(employeeModel);

        return employeeMapper.toDto(updatedEmployee);
    }

    @Override
    public List<EmployeeInitialDto> searchEmployees(String value) {

        List<EmployeeModel> fileteredList = employeeRepository
                .searchFlexible(value);

        return employeeMapper.toInitialDto(fileteredList);

    }
}
