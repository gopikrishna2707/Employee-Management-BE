package com.example.Employee_Be.repository;

import com.example.Employee_Be.models.UserDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsModel, Long> {

}
