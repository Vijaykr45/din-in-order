package com.example.dio.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CuisineType")
public class CuisineType {

    @Id
    @Column(name = "cuisine")
    private String cuisine;

    @ManyToMany(mappedBy = "cuisineTypes")
    private List<Restaurant> restaurant;

    @OneToMany(mappedBy = "cuisineType")
    private List<FoodItem> foodItems;




}
