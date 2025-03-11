package com.example.dio.service;

import com.example.dio.dto.request.RestaurantTableRequest;
import com.example.dio.dto.response.RestaurantTableResponse;

public interface RestaurantTableService {

    public  RestaurantTableResponse   createTable(long    restaurantId,   RestaurantTableRequest restaurantTableRequest);
}
