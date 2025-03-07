package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
public class RestaurantResponse {


    private Long restaurantId;

    private  String name ;

    private String address;

    private Long contactNumber ;

    private String email ;

    private LocalDateTime openAt ;

    private LocalDateTime closeAt ;

    private List<DietType> dietTypes;

    private LocalTime createdAt ;

    private LocalTime lastModifiedAt ;


    private List<String> cusintypes ;

}
