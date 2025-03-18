package com.example.dio.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemResponse {

    private long itemId;
    private FoodItemResponse foodItem;
    private int quantity;
    private double totalPrice;
}
