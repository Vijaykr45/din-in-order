package com.example.dio.service.impl;

import com.example.dio.dto.request.RestaurantTableRequest;
import com.example.dio.dto.response.RestaurantTableResponse;
import com.example.dio.exception.RestaurantNotFoundException;
import com.example.dio.mapper.RestaurantTableMapper;
import com.example.dio.model.Restaurant;
import com.example.dio.model.RestaurantTable;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.repository.RestaurantTableRepository;
import com.example.dio.service.RestaurantTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {



    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantTableMapper restaurantTableMapper;
    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantTableResponse createTable(long restaurantId, RestaurantTableRequest restaurantTableRequest) {
        RestaurantTable restaurantTable = restaurantTableMapper.mapToRestaurantTable(restaurantTableRequest);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow( () -> new RestaurantNotFoundException("Restaurant not found !!"));

        restaurantTable.setRestaurant(restaurant);
        restaurantTableRepository.save(restaurantTable);
        return restaurantTableMapper.mapToTableResponse(restaurantTable);



    }
}

