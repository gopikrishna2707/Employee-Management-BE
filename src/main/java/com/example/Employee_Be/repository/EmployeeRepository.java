package com.example.Employee_Be.repository;
import com.example.Employee_Be.models.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    boolean existsByEmail(String email);

    Optional<EmployeeModel> findByEid(String eid);

    void deleteByEid(String eid);

//    Page<EmployeeModel> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
//            String q1, String q2, String q3, String q4, Pageable pageable
//    );


    @Query(value = """
           SELECT *
           FROM employees
              LOWER(name)  LIKE LOWER(CONCAT('%', :value, '%'))
              OR LOWER(email) LIKE LOWER(CONCAT('%', :value, '%'))
           """,
            nativeQuery = true)
    List<EmployeeModel> searchFlexible(@Param("value") String value);
}
