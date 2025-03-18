package com.example.dio.dto.request;
import com.example.dio.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class FoodItemRequest {



    private String name;

    private double price;

    private String description;

    private int stock;

    @Pattern(regexp = "^(VEG|NON_VEG|VEGAN)$", message = "Diet type must be either 'VEG' or 'NON_VEG' or 'VEGAN'")
    private DietType dietType;

    private String cuisineType;

    private List<String> categories;


}
