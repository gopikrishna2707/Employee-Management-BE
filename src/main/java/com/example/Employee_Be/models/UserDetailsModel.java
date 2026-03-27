package com.example.Employee_Be.models;

import com.example.Employee_Be.models.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "UserDetails")
public class UserDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String email;
    private String password;
    private String userName;
    private UserRoles userRoles;

    public UserDetailsModel() {
    }

    public UserDetailsModel(Long id, String uid, String email, String password, String userName, UserRoles userRoles) {
        this.id = id;
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }
}
