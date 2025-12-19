package com.example.Employee_Be.mapper;

import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.models.EmployeeModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(EmployeeModel employeeModel);
    EmployeeModel toEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toEmployeeList(List<EmployeeModel> employeeModelList);

    //for basic employeeDetails
//    List<EmployeeInitialDto> toEmployeeBasicDetails(List<EmployeeModel> employeeModelList);

    List<EmployeeInitialDto> toInitialDto(List<EmployeeModel> employeeInitialModelList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    void updateEmployeeDetailsFromDto(EmployeeDto dto, @MappingTarget EmployeeModel entity);
}
