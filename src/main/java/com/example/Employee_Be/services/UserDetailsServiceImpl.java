package com.example.Employee_Be.services;

import com.example.Employee_Be.dto.UserDetailsDto;
import com.example.Employee_Be.models.UserDetailsModel;
import com.example.Employee_Be.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailsModel addUser(UserDetailsModel userDetailsModel) {

        UserDetailsModel newUser = new UserDetailsModel();


        newUser.setEmail(userDetailsModel.getEmail());
        newUser.setPassword(userDetailsModel.getPassword());
        newUser.setUserName(userDetailsModel.getUserName());
        newUser.setUserRoles(userDetailsModel.getUserRoles());

        // ✅ Generate UID (industry best: service layer UID generation)
        String uid = "U" + System.currentTimeMillis();  // OR UUID.randomUUID()
        newUser.setUid(uid);

        return userDetailsRepository.save(newUser);
    }

    @Override
    public List<UserDetailsModel> getAllUsers() {
        return userDetailsRepository.findAll();
    }
}
