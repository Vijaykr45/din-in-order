package com.example.dio.model;

import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private long userid ;

    @Column(name = "username")
    private String username ;

    @Column(name = "email")
    private String email ;

    @Column(name = "password")
    private String password;

    @Column(name = "ph_no")
    private String phno ;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role ;

    @Column(name = "created_at")
    private LocalDateTime createdat;

    @Column(name = "last_modified_at")
    private  LocalDateTime lastModifiedat;



}

