package com.example.dio.exception.handler;


import com.example.dio.exception.UserNotFoundException;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.SimpleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice

public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundError(UserNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<SimpleErrorResponse> handleAccessDeniedException(AccessDeniedException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}

