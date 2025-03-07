package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Entity
@Setter
@Getter
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;



    @Column(name = "name")
    private  String name ;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private Long contactNumber ;

    @Column(name = "email")
    private String email ;

    @Column(name = "open_at")
    private LocalDateTime openAt ;

    @Column(name = "close_at")
    private LocalDateTime closeAt ;

    @Column(name = "diet_type")
    private List<DietType> dietTypes;

    @Column(name = "created_at")
    private LocalTime createdAt ;

    @Column(name = "lastModified_at")
    private LocalTime lastModifiedAt ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin ;

    @ManyToMany(mappedBy = "restaurants" , fetch=  FetchType.EAGER)
    private List<CuisineType> cusintypes;


}
