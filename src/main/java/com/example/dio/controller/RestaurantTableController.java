package com.example.dio.controller;


import com.example.dio.dto.request.RestaurantTableRequest;
import com.example.dio.dto.response.RestaurantTableResponse;
import com.example.dio.service.RestaurantTableService;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantTableController {


    private  RestaurantTableService  restaurantTableService;

    @PostMapping("/tables/restaurant/{id}")
    public ResponseEntity<ResponseStructure<RestaurantTableResponse>> createTable(@PathVariable long id , @RequestBody RestaurantTableRequest restaurantTableRequest){


        RestaurantTableResponse restaurantTableResponse = restaurantTableService.createTable(id, restaurantTableRequest);


        return ResponseBuilder.created("Table created" , restaurantTableResponse);






    }
}
