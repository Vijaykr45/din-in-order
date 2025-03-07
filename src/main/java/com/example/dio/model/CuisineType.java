package com.example.dio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Setter
@Getter
@Table(name =  "cuisine")
public class CuisineType{

    @Id
    @Column(name = "cuisinename")
    private String  cuisineName ;

    @ManyToMany
    private List<Restaurant> restaurants ;



}
