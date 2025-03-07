package com.example.dio.exception.handler;


import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.exception.UserNotUpdatedByIdException;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class UserExceptionHandler {

   @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse>  handleUserNotFoundById(UserNotFoundByIdException ex ) {
        return ResponseBuilder.notFound(ex.getMessage());
    }


    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleUserNotUpdatedById(UserNotUpdatedByIdException excep) {
        return ResponseBuilder.notFound(excep.getMessage());
    }
}

