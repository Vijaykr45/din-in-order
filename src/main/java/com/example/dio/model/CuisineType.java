package com.example.dio.model;

import jakarta.persistence.*;
import org.mapstruct.MapMapping;

import java.util.List;

@Entity
@Table(name =  "cuisine")
public class CuisineType{

    @Id
    private List<Restaurant> cuisineType ;

    @ManyToMany (mappedBy =  "cuisineName")
    private  Restaurant restaurant ;



}
