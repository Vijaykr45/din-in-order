package com.example.dio.model;

import jakarta.persistence.*;
import org.mapstruct.MapMapping;

@Entity
@Table(name =  "cuisine")
public class CuisineType{

    @Id
    private String cuisineType ;

    @ManyToMany (mappedBy =  "cuisinename")
    private  Restaurant restaurant ;



}
