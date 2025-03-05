package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Table(name = "restaurant")
public class Restaurant {

    @OneToMany
    private Admin admin ;

    @ManyToMany(mappedBy = "restaurant" , fetch=  FetchType.EAGER)
    private  CuisineType cusintype ;

    private int restaurantId;
    private  String name ;
    private String address;
    private Long contactNumber ;
    private String email ;
    private LocalDateTime openAt ;
    private LocalDateTime closeAt ;
    private DietType dietType;
    private LocalTime createdAt ;
    private LocalTime lastModifiedAt ;

}
