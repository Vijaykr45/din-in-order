package com.example.dio.model;

import com.example.dio.enums.DietType;
import com.example.dio.enums.Stock;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "fooditems")
public class FoodItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated
    private DietType dietType ;

    @Column(name =  "createdAt")
    @CreatedDate
    private LocalDateTime createdAt ;

    @Column(name = "lastModifiedAt")
    @LastModifiedDate
    private LocalDateTime lastModifiedAt ;


    @ManyToOne
    private Restaurant restaurant ;

    @ManyToOne
    private  CuisineType cuisineType ;

    @ManyToMany
    private List<Category> categories;


    @OneToMany(mappedBy = "foodItem")
    private List<CartItem> cartItems;

}
