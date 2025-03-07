package com.example.dio.exception;

public class UserNotUpdatedByIdException extends RuntimeException{

    private String message;

    public UserNotUpdatedByIdException(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

}
