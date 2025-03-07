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
     *
     * used for set restaurantRequest (DTO class to update) data in user object
     *
     * @param restaurantRequest DTO class with updated restaurant details
     * @return restaurent object with RestaurantRequest data
     */
    RestaurantResponse mapToRestaurantEntity(RestaurantResponse restaurantResponse);

    /**
     * getting string value and storing in CuisineType object
     *
     * @param value cuisine type getting in string type
     * @return object of cuisine with string name
     */
    Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);


    default CuisineType mapToCuisineType(String value) {
        if(value == null) {
            return null;
        }
        else {
            CuisineType type = new CuisineType();
            type.setCuisine(value);
            return type;
        }
    }

    /**
     * converting cuisine type into String for restaurant response
     *
     * @param value cuisineType object with name
     * @return cuisine name as string
     */

    default String mapToString(CuisineType value) {
        if(value == null) {
            return null;
        }
        else return value.getCuisine();
    }

    /**
     * create and return structure of restaurentResponse using user object details
     *
     * @param restaurent user entity object
     * @return restaurentResponse object to send restricted attribute
     */

    RestaurantResponse mapToRestaurantResponce(Restaurant restaurant);







}
