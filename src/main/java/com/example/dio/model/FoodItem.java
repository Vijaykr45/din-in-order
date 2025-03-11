package com.example.dio.model;

import com.example.dio.enums.DietType;
import com.example.dio.enums.Stock;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(name = "fooditems")
public class FoodItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId")
    private Long itemId ;



    @Column(name = "name" )
    private String name ;

    @Column(name = "price")
    private  int price ;

    @Column(name =  "description")
    private String description ;

    @Column(name = "stocks")
    private int stock ;

    @Column(name = "availability")
    private Stock availability ;

    @Column(name = "dietType")
    private DietType dietType ;

    @Column(name =  "createdAt")
    private LocalDateTime createdAt ;

    @Column(name = "lastModifiedAt")
    private LocalDateTime lastModifiedAt ;


    @ManyToOne
    private Restaurant restaurant ;

    @ManyToOne
    private  CuisineType cuisineType ;

}
