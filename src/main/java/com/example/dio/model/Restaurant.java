package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private Long restaurantId;


    @OneToMany
    private Admin admin ;

    @ManyToMany(mappedBy = "restaurant" , fetch=  FetchType.EAGER)
    private  CuisineType cusintype ;


    @Column(name = "name")
    private  String name ;

    @Column(name = "address")
    private String address;

    @Column(name = "contactNumber")
    private Long contactNumber ;

    @Column(name = "email")
    private String email ;

    @Column(name = "openAt")
    private LocalDateTime openAt ;

    @Column(name = "closeAt")
    private LocalDateTime closeAt ;

    @Column(name = "dietType")
    private DietType dietType;

    @Column(name = "createdAt")
    private LocalTime createdAt ;

    @Column(name = "lastModifiedAt")
    private LocalTime lastModifiedAt ;

}
