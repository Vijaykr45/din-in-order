package com.example.dio.utility;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class ResponseBuilder {

    /**
     * Builds a structured success response with a given HTTP status, message, and data.
     *
     * This method is useful when sending a structured response that includes:
     * - The HTTP status code
     * - A custom message to describe the response
     * - Any data that needs to be returned
     *
     * @param status  The HTTP status code to be returned (e.g., 200 OK, 201 CREATED).
     * @param message A message describing the response (e.g., "Operation Successful").
     * @param data    The response payload (can be any type).
     * @param <T>     The type of data being returned.
     * @return        A ResponseEntity containing the structured response.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())  // Setting HTTP status code
                .message(message)        // Attaching the response message
                .data(data)              // Attaching response data
                .build();

        return ResponseEntity.status(status).body(structure);
    }



    /**
     * Builds a structured success response with additional HTTP headers.
     *
     * This method is useful when you need to:
     * - Attach headers like Authorization, Content-Type, etc.
     * - Maintain a consistent response structure
     * - Include a success message and data
     *
     * @param status    The HTTP status code to be returned.
     * @param headers   Additional HTTP headers to be included in the response.
     * @param message   A message describing the response.
     * @param data      The response payload.
     * @param <T>       The type of data being returned.
     * @return          A ResponseEntity containing the structured response.
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
     * Builds a standard HTTP 200 OK response.
     *
     * This method is a shortcut for sending success responses with an HTTP 200 status.
     *
     * @param message A message describing the response.
     * @param data    The response payload.
     * @param <T>     The type of data being returned.
     * @return        A ResponseEntity with a 200 OK status.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> ok(String message, T data) {
        return success(HttpStatus.OK, message, data);
    }



    /**
     * Builds a standard HTTP 201 Created response.
     *
     * This method is used when creating a new resource and returning a response
     * with an HTTP 201 status to indicate successful creation.
     *
     * @param message A message describing the response.
     * @param data    The response payload.
     * @param <T>     The type of data being returned.
     * @return        A ResponseEntity with a 201 Created status.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> created(String message, T data) {
        return success(HttpStatus.CREATED, message, data);
    }



    /**
     * Builds an error response with a given HTTP status and error message.
     *
     * This method is used when an error occurs, and a structured error response
     * needs to be sent to the client.
     *
     * @param status  The HTTP status code to be returned (e.g., 400, 404, 500).
     * @param message A message describing the error.
     * @return        A ResponseEntity containing the structured error response.
     */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())    // Setting error type (e.g., NOT_FOUND, BAD_REQUEST)
                .message(message)       // Attaching the error message
                .status(status.value()) // Setting HTTP status code
                .build();

        return ResponseEntity.status(status).body(error);
    }



    /**
     * Builds an error response that includes validation errors.
     *
     * This method is useful when handling request validation errors,
     * such as missing required fields or incorrect formats.
     *
     * @param status  The HTTP status code to be returned (e.g., 400 BAD_REQUEST).
     * @param message A general error message describing the issue.
     * @param errors  A list of specific field validation errors.
     * @return        A ResponseEntity containing the structured validation error response.
     */
    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.CustomFieldError> errors) {
        FieldErrorResponse fieldError = FieldErrorResponse.builder()
                .type(status.name())
                .status(status.value())
                .message(message)
                .errors(errors)  // Attaching list of field errors
                .build();

        return ResponseEntity.status(status).body(fieldError);
    }



    /**
     * Builds an HTTP 404 Not Found error response.
     *
     * This method is a shortcut for sending structured error responses
     * when a requested resource is not found.
     *
     * @param message A message describing the missing resource.
     * @return        A ResponseEntity with a 404 Not Found status.
     */
    public static ResponseEntity<SimpleErrorResponse> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }




    /**
     * Builds a structured validation error response.
     *
     * This method is used when a request fails validation due to incorrect or missing data.
     * It provides a detailed response structure, including:
     * - HTTP status code
     * - Error message
     * - List of validation errors
     *
     * @param httpStatus The HTTP status code to be returned.
     * @param message    A message describing the validation failure.
     * @param errors     A list of validation errors for specific fields.
     * @return          A ResponseEntity containing the structured validation error response.
     */
    public static ResponseEntity<ValidationErrorStructure> validationError(HttpStatus httpStatus, String message, List<ValidationErrorStructure.Errors> errors) {
        ValidationErrorStructure errorStructure = ValidationErrorStructure.builder()
                .status(httpStatus.value())  // Setting HTTP status code
                .message(message)          // Attaching error message
                .type(httpStatus.name())   // Setting error type (e.g., BAD_REQUEST)
                .errors(errors)            // Attaching list of validation errors
                .build();

        return ResponseEntity.status(httpStatus).body(errorStructure);
    }
}
