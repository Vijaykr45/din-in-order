package com.example.dio.dto.request;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class FoodItemRequest {



    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name ;

    @Column(name = "cuisineType")
    @NotBlank(message = "Cuisine type cannot be blank")
    @Size(min = 3, max = 50, message = "Cuisine type must be between 3 and 50 characters")
    private String cuisineType;


    @Column(name = "price")
    @Min(value = 0, message = "Price must be a positive number")
    private  int price ;

    @Column(name = "description")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description ;


    @Column(name = "stock")
    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Column(name = "createdAt")
    @PastOrPresent(message = "Created date cannot be in the future")
    private LocalDateTime createdAt;

    @Column(name = "lastModifiedAt")
    @PastOrPresent(message = "Last modified date cannot be in the future")
    private LocalDateTime lastModifiedAt;




}
