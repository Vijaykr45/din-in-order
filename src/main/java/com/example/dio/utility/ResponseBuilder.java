package com.example.dio.utility;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;


public class ResponseBuilder {

    /**
     * helps to Builds a success response with a given HTTP status, message, and data.
     *
     * @param status  the HTTP status to be returned.
     * @param message the message describing the responses.
     * @param data    the response payload.
     * @param <T>     the type of data being returned.
     * @return        -> return a ResponseEntity containing the structured response.
     */


    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).body(structure);
    }

    /**
     * Builds a success response with a given HTTP status, headers, message, and data.
     *
     * @param status    -> the HTTP status to be returned.
     * @param headers   -> the HTTP headers to be included in the response.
     * @param message   -> the message describing the response.
     * @param data      -> the response payload.
     * @param <T>       -> the type of data being returned.
     * @return          -> a ResponseEntity containing the structured response.
     */



    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).headers(headers).body(structure);
    }

    /**
     * Builds an HTTP 200 OK success response with the given message and data.
     *
     * @param message the message describing the response.
     * @param data    the response payload.
     * @param <T>     the type of data being returned.
     * @return       -> a ResponseEntity containing the structured response.
     */





    public static <T> ResponseEntity<ResponseStructure<T>> ok(String message, T data) {
        return success(HttpStatus.OK, message, data);
    }

    /**
     * Builds an HTTP 201 Created success response with the given message and data.
     *
     * @param message the message describing the response.
     * @param data    the response payload.
     * @param <T>     the type of data being returned.
     * @return       ->  a ResponseEntity containing the structured response.
     */





    public static <T> ResponseEntity<ResponseStructure<T>> created(String message, T data) {
        return success(HttpStatus.CREATED, message, data);
    }

    /**
     * Builds an error response with a given HTTP status and message.
     *
     * @param status  the HTTP status to be returned.
     * @param message the error message describing the issue.
     * @return       ->  a ResponseEntity containing the structured success response.
     */







    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    /**
     * Builds an error response with a given HTTP status, message, and a list of field-specific validation errors.
     *
     * @param status  the HTTP status to be returned.
     * @param message the error message describing the issue.
     * @param errors  a list of field-specific validation errors.
     * @return       -> a ResponseEntity containing the structured field error response.
     */





    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.CustomFieldError> errors) {
        FieldErrorResponse fieldError = FieldErrorResponse.builder()
                .type(status.name())
                .status(status.value())
                .message(message)
                .errors(errors)
                .build();

        return ResponseEntity.status(status).body(fieldError);
    }

    /**
     * Builds an HTTP 404 Not Found error response with the given message.
     *
     * @param message the error message describing the issue.
     * @return    ->  a ResponseEntity containing the structured error response.
     */





    public static ResponseEntity<SimpleErrorResponse> notFound(String message) {

        return error(HttpStatus.NOT_FOUND , message);
    }
}
