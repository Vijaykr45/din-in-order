package com.example.dio.dto.response;


import com.example.dio.enums.DietType;
import com.example.dio.enums.Stock;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FoodItemResponse {


    private long id;
    private String name;
    private double price;
    private String description;
    private Stock availability;
    private DietType dietType;
    private String cuisineType;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;


}
