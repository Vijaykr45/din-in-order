package com.example.dio.exception.handler;

import com.example.dio.exception.FoodNotFoundException;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.SimpleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class FoodExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleRestaurantNotFoundException(FoodNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleNoSuchElementException(NoSuchElementException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
