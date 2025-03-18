package com.example.dio.service.impl;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.exception.FoodNotFoundException;
import com.example.dio.mapper.CartItemMapper;
import com.example.dio.model.CartItem;
import com.example.dio.model.FoodItem;
import com.example.dio.model.RestaurantTable;
import com.example.dio.repository.CartItemRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.RestaurantTableRepository;
import com.example.dio.service.CartItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {


    private final CartItemMapper cartItemMapper;
    private final RestaurantTableRepository restaurantTableRepository;
    private final FoodItemRepository foodItemRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItemResponse createCartItem(long tableId, long foodId, int quantity) {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(tableId)
                .orElseThrow(() ->new InvalidParameterException("Table Not Found !!"));

        FoodItem foodItem = foodItemRepository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food Not Found To Add In Cart"));

        CartItem cartItem = cartItemRepository.save(
                getCartItem(quantity, foodItem, restaurantTable));

        return cartItemMapper.mapToCartItemResponse(cartItem);


    }

    @Override
    public CartItemResponse updateQuantity(long cartId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item with ID " + cartId + " not found"));

        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(cartItem.getFoodItem().getPrice() * quantity);

        return cartItemMapper.mapToCartItemResponse(
                cartItemRepository.save(cartItem)
        );
    }

    private static CartItem getCartItem(int quantity, FoodItem foodItem, RestaurantTable restaurantTable) {
        CartItem cartItem = new CartItem();
        cartItem.setFoodItem(foodItem);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(foodItem.getPrice() * quantity);
        cartItem.setRestaurantTable(restaurantTable);
        cartItem.setOrder(false);
        return cartItem;
    }

}
