package com.example.Employee_Be.services;
import com.example.Employee_Be.dto.EmployeeDto;
import com.example.Employee_Be.dto.EmployeeInitialDto;
import com.example.Employee_Be.exception.EmployeeException;
import com.example.Employee_Be.mapper.EmployeeMapper;
import com.example.Employee_Be.models.EmployeeModel;
import com.example.Employee_Be.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    EmployeeMapper employeeMapper;

    String existedEmail = "exist@gamil.com";

    private EmployeeModel sampleModel() {
        EmployeeModel m = new EmployeeModel();
        m.setId(1);
        m.setEid("E-1001");
        m.setName("Abc");
        m.setEmail("abc@example.com");
        m.setCurrentlyWorking("Yes");
        return m;
    }


    private EmployeeDto sampleDto() {
        EmployeeDto d = new EmployeeDto();
        d.setId(1);
        d.setEid("E-1001");
        d.setName("Abc");
        d.setEmail("abc@example.com");
        d.setCurrentlyWorking("Yes");
        return d;
    }


//  adding an employee successfully
    @Test
    @DisplayName("addEmployee: should map dto -> entity -> saved -> dto and return")
    void addEmployeeSuccessfully() {
        // Arrange
        EmployeeModel employee = sampleModel();
        EmployeeDto employeeDto = sampleDto();

        when(employeeMapper.toEntity(employeeDto)).thenReturn(employee);
        when(employeeRepository.save(employee)).thenReturn(employee);
        when(employeeMapper.toDto(employee)).thenReturn(employeeDto);

        // Act
        EmployeeDto result = employeeService.addEmployee(employeeDto);

        // Assert
        assertEquals(employeeDto.getId(), result.getId());
        assertEquals(employeeDto.getEid(), result.getEid());
        verify(employeeMapper).toEntity(employeeDto);
        verify(employeeRepository).save(employee);
        verify(employeeMapper).toDto(employee);
    }

    // =========================================================
    // findEmployeeByEid
    // =========================================================
    @Test
    @DisplayName("findEmployeeByEid: returns DTO when found")
    void findEmployeeByEid_Found() {
        // Arrange
        String eid = "E-1001";
        EmployeeModel model = sampleModel();
        EmployeeDto dto = sampleDto();

        when(employeeRepository.findByEid(eid)).thenReturn(Optional.of(model));
        when(employeeMapper.toDto(model)).thenReturn(dto);
        // Act
        EmployeeDto result = employeeService.findEmployeeByEid(eid);
        // Assert
        assertNotNull(result);
        assertEquals(eid, result.getEid());
        verify(employeeRepository).findByEid(eid);
        verify(employeeMapper).toDto(model);
    }

    @Test
    @DisplayName("findEmployeeByEid: throws EmployeeException when not found")
    void findEmployeeByEid_NotFound() {
        // Arrange
        String eid = "E-404";
        when(employeeRepository.findByEid(eid)).thenReturn(Optional.empty());
        // Act + Assert
        EmployeeException ex = assertThrows(EmployeeException.class,
                () -> employeeService.findEmployeeByEid(eid));
        // You can assert message if desired:
        // assertTrue(ex.getMessage().contains(eid));
        verify(employeeRepository).findByEid(eid);
        verifyNoInteractions(employeeMapper);
    }

    // =========================================================
    // deleteEmployeeById
    // =========================================================
    @Test
    @DisplayName("deleteEmployeeById: deletes and returns DTO of deleted employee")
    void deleteEmployeeById_Success() {
        // Arrange
        String eid = "E-1001";
        EmployeeModel model = sampleModel();
        EmployeeDto dto = sampleDto();

        when(employeeRepository.findByEid(eid)).thenReturn(Optional.of(model));
        doNothing().when(employeeRepository).deleteByEid(eid);
        when(employeeMapper.toDto(model)).thenReturn(dto);
        // Act
        EmployeeDto result = employeeService.deleteEmployeeById(eid);
        // Assert
        assertNotNull(result);
        assertEquals(eid, result.getEid());
        verify(employeeRepository).findByEid(eid);
        verify(employeeRepository).deleteByEid(eid);
        verify(employeeMapper).toDto(model);
    }

    @Test
    @DisplayName("deleteEmployeeById: throws EmployeeException when not found")
    void deleteEmployeeById_NotFound() {
        // Arrange
        String eid = "E-404";
        when(employeeRepository.findByEid(eid)).thenReturn(Optional.empty());

        // Act + Assert
        EmployeeException ex = assertThrows(EmployeeException.class,
                () -> employeeService.deleteEmployeeById(eid));
        assertTrue(ex.getMessage().contains("Employee not found"));
        verify(employeeRepository).findByEid(eid);
        verify(employeeRepository, never()).deleteByEid(anyString());
        verifyNoInteractions(employeeMapper);
    }

    // =========================================================
    // updateEmployeeById
    // =========================================================
    @Test
    @DisplayName("updateEmployeeById: updates details and returns updated DTO")
    void updateEmployeeById_Success() {
        // Arrange
        String eid = "E-1001";
        EmployeeModel existing = sampleModel();

        EmployeeDto incomingDto = sampleDto();
        incomingDto.setName("Updated Name");
        incomingDto.setEmail("updated@example.com");
        incomingDto.setCurrentlyWorking("No");

        EmployeeModel saved = sampleModel();
        saved.setName(incomingDto.getName());
        saved.setEmail(incomingDto.getEmail());
        saved.setCurrentlyWorking(incomingDto.getCurrentlyWorking());

        EmployeeDto expected = sampleDto();
        expected.setName(saved.getName());
        expected.setEmail(saved.getEmail());
        expected.setCurrentlyWorking(saved.getCurrentlyWorking());

        when(employeeRepository.findByEid(eid)).thenReturn(Optional.of(existing));

        // mapper updates the existing model in place
        doAnswer(inv -> {
            EmployeeDto dtoArg = inv.getArgument(0);
            EmployeeModel modelArg = inv.getArgument(1);
            // mimic mapper behavior
            modelArg.setName(dtoArg.getName());
            modelArg.setEmail(dtoArg.getEmail());
            modelArg.setCurrentlyWorking(dtoArg.getCurrentlyWorking());
            return null;
        }).when(employeeMapper).updateEmployeeDetailsFromDto(incomingDto, existing);

        when(employeeRepository.save(existing)).thenReturn(saved);
        when(employeeMapper.toDto(saved)).thenReturn(expected);

        // Act
        EmployeeDto result = employeeService.updateEmployeeById(eid, incomingDto);

        // Assert
        assertEquals("Updated Name", result.getName());
        assertEquals("updated@example.com", result.getEmail());
        assertEquals("No", result.getCurrentlyWorking());
        verify(employeeRepository).findByEid(eid);
        verify(employeeMapper).updateEmployeeDetailsFromDto(incomingDto, existing);
        verify(employeeRepository).save(existing);
        verify(employeeMapper).toDto(saved);
    }

    @Test
    @DisplayName("updateEmployeeById: throws when name or email is empty")
    void updateEmployeeById_EmptyNameOrEmail() {
        // Arrange
        String eid = "E-1001";
        EmployeeModel existing = sampleModel();
        EmployeeDto bad = sampleDto();
        bad.setName("");                 // invalid
        bad.setEmail("");                // invalid

        when(employeeRepository.findByEid(eid)).thenReturn(Optional.of(existing));

        // Act + Assert
        EmployeeException ex = assertThrows(EmployeeException.class,
                () -> employeeService.updateEmployeeById(eid, bad));
        assertTrue(ex.getMessage().contains("name and email cant be null"));
        verify(employeeRepository).findByEid(eid);
        verify(employeeMapper, never()).updateEmployeeDetailsFromDto(any(), any());
        verify(employeeRepository, never()).save(any());
    }

    @Test
    @DisplayName("updateEmployeeById: throws when currentlyWorking is empty")
    void updateEmployeeById_EmptyCurrentlyWorking() {
        // Arrange
        String eid = "E-1001";
        EmployeeModel existing = sampleModel();
        EmployeeDto bad = sampleDto();
        bad.setCurrentlyWorking("");     // invalid

        when(employeeRepository.findByEid(eid)).thenReturn(Optional.of(existing));

        // Act + Assert
        EmployeeException ex = assertThrows(EmployeeException.class,
                () -> employeeService.updateEmployeeById(eid, bad));
        assertTrue(ex.getMessage().contains("employee current working is mandatory"));
        verify(employeeRepository).findByEid(eid);
        verify(employeeMapper, never()).updateEmployeeDetailsFromDto(any(), any());
        verify(employeeRepository, never()).save(any());
    }

    @Test
    @DisplayName("updateEmployeeById: throws when model not found by eid")
    void updateEmployeeById_NotFound() {
        // Arrange
        String eid = "E-404";
        EmployeeDto incomingDto = sampleDto();
        when(employeeRepository.findByEid(eid)).thenReturn(Optional.empty());

        // Act + Assert
        EmployeeException ex = assertThrows(EmployeeException.class,
                () -> employeeService.updateEmployeeById(eid, incomingDto));
        assertTrue(ex.getMessage().contains("Not found the id"));
        verify(employeeRepository).findByEid(eid);
        verifyNoInteractions(employeeMapper);
    }

    // =========================================================
    // searchEmployees
    // =========================================================
    @Test
    @DisplayName("searchEmployees: returns mapped initial DTOs")
    void searchEmployees_ReturnsInitialDtos() {
        // Arrange
        String value = "abc";
        List<EmployeeModel> found = List.of(sampleModel(), sampleModel());

        EmployeeInitialDto i1 = new EmployeeInitialDto(
                1,
                "E-1001",
                "Xyz1",
                "Yes",
                "xyz1@example.com",
                BigDecimal.valueOf(90000)
        );

        EmployeeInitialDto i2 = new EmployeeInitialDto(
                2,
                "E-1002",
                "Xyz",
                "No",
                "xyz@example.com",
                BigDecimal.valueOf(90000));

        List<EmployeeInitialDto> mapped = List.of(i1, i2);

        when(employeeRepository.searchFlexible(value)).thenReturn(found);
        when(employeeMapper.toInitialDto(found)).thenReturn(mapped);

        // Act
        List<EmployeeInitialDto> result = employeeService.searchEmployees(value);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("E-1001", result.get(0).getEid());
        verify(employeeRepository).searchFlexible(value);
        verify(employeeMapper).toInitialDto(found);
    }
}
