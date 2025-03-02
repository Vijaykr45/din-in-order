package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long userId;
    private String userName;
    private UserRole role ;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt ;
}
