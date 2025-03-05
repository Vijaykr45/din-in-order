package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import com.example.dio.model.Admin;
import com.example.dio.model.CuisineType;
import com.example.dio.model.Restaurant;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class RestaurantResponse {


    private Long restaurantId;

    private  String name ;

    private String address;

    private Long contactNumber ;

    private String email ;

    private LocalDateTime openAt ;

    private LocalDateTime closeAt ;

    private List<DietType> dietType;

    private LocalTime createdAt ;

    private LocalTime lastModifiedAt ;


    private List<CuisineType> cusintype ;

}
