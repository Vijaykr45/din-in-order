package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
public class RestaurantResponse {


    private Long restaurantId;
    private String name;
    private String address;
    private String contactNumber;
    private String contactEmail;
    private LocalDateTime opensAt;
    private LocalDateTime closeAt;
    private List<DietType> dietTypes;
    private LocalDateTime lastModifiedAt;
    private LocalDateTime createdAt;
    private List<String> cuisineTypes;

}
