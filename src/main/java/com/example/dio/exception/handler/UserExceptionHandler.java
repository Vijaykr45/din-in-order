package com.example.dio.exception.handler;


import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.exception.UserNotUpdatedByIdException;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    public ResponseEntity<SimpleErrorResponse>  getMessage(UserNotFoundByIdException ex ) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }


    public ResponseEntity<SimpleErrorResponse> getMessage(UserNotUpdatedByIdException excep) {
        return ResponseBuilder.error(HttpStatus.NOT_MODIFIED, excep.getMessage());
    }
}
