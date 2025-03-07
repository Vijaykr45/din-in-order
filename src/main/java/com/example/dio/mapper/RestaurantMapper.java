package com.example.dio.mapper;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.CuisineType;
import com.example.dio.model.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    /**
     * Converts a {@link RestaurantResponse} DTO to a {@link Restaurant} entity.
     *
     * @param restaurantResponse the response DTO containing restaurant details
     * @return the mapped {@link Restaurant} entity
     */
    RestaurantResponse mapToRestaurantEntity(RestaurantResponse restaurantResponse);


    /**
     * Converts a {@link RestaurantRequest} DTO to a {@link Restaurant} entity.
     *
     * @param restaurantRequest the request DTO containing restaurant details
     * @return the mapped {@link Restaurant} entity
     */
    Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);



    default  String map(CuisineType cuisineType) {
        if(cuisineType!= null) {
            return cuisineType.getCuisineName();
        }
        else {
            return  null ;
        }
    }



    default  CuisineType map (String value){
        if(value == null) {
            CuisineType cuisineType = new CuisineType();
            cuisineType.setCuisineName(value);
            return  cuisineType ;
        }
        else
         return null ;
    }


}
