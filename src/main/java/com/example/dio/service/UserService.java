package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;

/**
 *
 * It defines methods  without exposing business logic to clients.
 * UserService interface should be implemented by a service class  write the businesslogic and return the responses
 *
 */

public interface UserService {



    /**
     * Registers a new user based on the provided registration request.
     *
     * @param registrationRequest the request object containing user registration details.
     * @return a UserResponse containing the details of the newly registered user.
     */
    UserResponse registerUser(RegistrationRequest registrationRequest);



    /**
     * Finds a user by their unique ID.
     *
     * @param userId it search the related userid and take all the details of the user and give the response . .
     * @return a UserResponse containing the user's details .
     */
    UserResponse findUserById(Long userId);





    /**
     * Updates an existing user's details based on the provided request.
     *
     * @param userRequest the request object containing updated user details.
     * @param userId      the unique identifier of the user to be updated.
     * @return a UserResponse containing the updated user details.
     */
    UserResponse updateUserById(UserRequest userRequest, long userId);
}
