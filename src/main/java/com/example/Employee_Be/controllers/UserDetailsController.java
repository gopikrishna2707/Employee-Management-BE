package com.example.Employee_Be.controllers;

import com.example.Employee_Be.dto.UserDetailsDto;
import com.example.Employee_Be.models.UserDetailsModel;
import com.example.Employee_Be.services.UserDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User Management")
@CrossOrigin(origins = {"https://gopikrishna2707.github.io", "http://localhost:4200"})
public class UserDetailsController {

    UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("user-details")
    public UserDetailsModel addDetails(@RequestBody UserDetailsModel userDetailsModel){
        return userDetailsService.addUser(userDetailsModel);
    }

    @GetMapping("user-details")
    public List<UserDetailsModel> getAllUserDetails(){
        return userDetailsService.getAllUsers();
    }
}
