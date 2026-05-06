package com.example.Employee_Be.models;

import com.example.Employee_Be.models.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "User_details")
public class UserDetailsModel implements UserDetails {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @JoinColumn(unique = true)
    private String uid;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

    @Getter
    @Setter
    private String username;

    public UserDetailsModel() {
    }

    public UserDetailsModel(Long id, String uid, String email, String password, String username) {
        this.id = id;
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

}
