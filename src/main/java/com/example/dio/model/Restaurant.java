package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "restaurant")
public class Restaurant {


        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name = "restaurant_id")
        private long restaurantId;

        @Column(name = "restaurant_name")
        private String name;

        @Column(name = "address")
        private String address;

        @Column(name = "Phone_no")
        private String contactNumber;

        @Column(name = "email")
        private String contactEmail;

        @Column(name = "open_at")
        private LocalDateTime opensAt;

        @Column(name = "close_at")
        private LocalDateTime closeAt;

        @Enumerated
        @Column(name = "diet_type")
        private List<DietType> dietTypes;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "last_modified_at")
        private LocalDateTime lastModifiedAt;

        @ManyToOne(fetch = FetchType.LAZY)
        private Admin admin;

        @ManyToMany(fetch = FetchType.EAGER)
        private List<CuisineType> cuisineTypes;
    }

