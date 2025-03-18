package com.example.dio.service.impl;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user = this.createUserByRole(registrationRequest.getRole());
        userMapper.mapToUserEntity(registrationRequest,user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    // Mapper will automatically sett these field interneally

//    private UserResponse mapToUserResponse(User user1) {
//        return  UserResponse.builder()
//                .userId(user1.getUserId())
//                .userName(user1.getUserName())
//                .role(user1.getRole())
//                .createdAt(user1.getCreatedAt())
//                .lastModifiedAt(user1.getLastModifiedAt())
//                .build();
//
//    }
//
//    private void mapToUserEntity(RegistrationRequest registrationRequest, User user1) {
//        user1.setUserName(registrationRequest.getUserName());
//        user1.setEmail(registrationRequest.getEmail());
//        user1.setPassword(registrationRequest.getPassword());
//        user1.setPhNo(registrationRequest.getPhNo());
//        user1.setRole(registrationRequest.getRole());
//    }




    private User createUserByRole (UserRole role){
        User user2;
        switch (role){
            case ADMIN -> user2 = new Admin();
            case STAFF -> user2 = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invalid user type");
        }
        return user2;
    }

    /**
     * Produces and return child child instance of the user based on the user role
     *
     * @param  role the role of the user
     * @return User the parent references containing either of Staff or Admin instance
     *
     * */






    @Override
    public UserResponse findUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::mapToUserResponse)
                .orElseThrow(() -> new UserNotFoundException("Failed to find user , User not found by Id"));
    }



    @Override
    public UserResponse updateUserById(UserRequest userRequest, long userId) {
        return userRepository.findById(userId)
                .map(exUser -> {  // Corrected the lambda expression syntax
                    userMapper.mapToUserEntity(userRequest, exUser);
                    userRepository.save(exUser);
                    return userMapper.mapToUserResponse(exUser);
                })
                .orElseThrow(() -> new UserNotFoundException("Failed to update user, user not found by ID"));
    }




}