package com.example.dio.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantTableRequest {

    private String tableNumber;
    private int tableCapacity;

}
