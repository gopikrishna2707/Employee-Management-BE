package com.example.Employee_Be.services;

import com.example.Employee_Be.dto.UserDetailsDto;
import com.example.Employee_Be.models.UserDetailsModel;

import java.util.List;

public interface UserDetailsService {

    UserDetailsModel addUser(UserDetailsModel userDetailsModel);

    List<UserDetailsModel> getAllUsers();
}
