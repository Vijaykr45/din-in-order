package com.example.dio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int itemId ;

    private  int quantity ;
    private  int totalPrice ;
    private String order ;


    @ManyToOne
    private FoodItem foodItem ;

    @ManyToOne
    private RestaurantTable restaurantTable ;



}
