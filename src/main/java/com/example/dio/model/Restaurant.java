package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantId")
    private Long restaurantId;



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
    private List<DietType> dietType;

    @Column(name = "createdAt")
    private LocalTime createdAt ;

    @Column(name = "lastModifiedAt")
    private LocalTime lastModifiedAt ;

    @OneToMany(fetch = FetchType.LAZY)
    private Admin admin ;

    @ManyToMany(mappedBy = "restaurant" , fetch=  FetchType.EAGER)
    private List<CuisineType> cusintype ;


}
