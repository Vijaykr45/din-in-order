package com.example.dio.service.impl;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.exception.RestaurantNotFoundException;
import com.example.dio.mapper.FoodItemMapper;
import com.example.dio.model.CuisineType;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Restaurant;
import com.example.dio.repository.CuisineRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.service.FoodItemService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FoodItemServiceImpl implements FoodItemService {


    private final RestaurantRepository restaurantRepository;
    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;
    private final CuisineRepository cuisineRepository;

    @Override
    @Transactional
    public FoodItemResponse createFoodItem(long id, FoodItemRequest foodItemRequest) {


        FoodItem foodItem = foodItemMapper.mapToFoodItem(foodItemRequest);

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found !!"));

        cuisineRepository.findById(foodItem.getCuisineType().getCuisine())
                .orElseGet(() -> {
                    CuisineType cuisineType = cuisineRepository.save(foodItem.getCuisineType());
                    restaurant.getCuisineTypes().add(cuisineType);
                    restaurantRepository.save(restaurant);
                    return cuisineType;
                });

        foodItem.setRestaurant(restaurant);
        foodItem.setCuisineType(foodItem.getCuisineType());

        foodItemRepository.save(foodItem);

        return foodItemMapper.mapToFoodItemResponse(foodItem);
    }
}
