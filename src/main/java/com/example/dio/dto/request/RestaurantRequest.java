package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
public class RestaurantRequest {

    @NotBlank(message = "Restaurant name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Restaurant name can only contain alphabets, numbers, and underscores")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    private String address;


    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Phone number must be a valid 10-digit number starting with 7, 8, or 9")
    private String contactNumber;


    @NotBlank(message = "Email cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;


    @NotNull(message = "Opening time cannot be null")
    private LocalDateTime openAt;


    @NotNull(message = "Closing time cannot be null")
    private LocalDateTime closeAt;


    @NotEmpty(message = "At least one diet type must be provided")
    private List<DietType> dietTypes;


    @NotEmpty(message = "At least one cuisine type must be provided")
    private List<String> cuisineTypes;
}
