package ru.kata.preproject.SpringSecurityApp.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, message = "Не меньше 5 знаков")
    @Column(name = "username")
    private String username;
    @Column(name = "year_of_birth")
    private int birthYear;
    @Column(name = "password")
    @Size(min = 2, message = "Не меньше 5 знаков")
    private String password;
    @Column(name = "role")
    private String role;
    @Transient
    private String passwordConfirm;


    public User() {
    }

    public User(String username, int birthYear) {
        this.username = username;
        this.birthYear = birthYear;
    }
}




