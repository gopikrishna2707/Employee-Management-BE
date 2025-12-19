package com.example.Employee_Be.repository;

import com.example.Employee_Be.models.UserManagementService;
import com.example.Employee_Be.models.enums.EmployeeRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRoleRepository extends JpaRepository<UserManagementService, Long> {

    Optional<UserManagementService> findByUsername(String username);
    boolean existsByUsername(String username);

}
