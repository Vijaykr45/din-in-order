package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegistrationRequest {

//    @NotNull
//    @NotBlank  both the annotation are cmbined in @NotEmpty
    @NotBlank(message =  "User name cannot be  blank ")
    @NotEmpty(message =  "User name cannot be null and blank ")
    private String username ;

    @NotBlank(message =  "User email cannot be blank ")
    @NotEmpty(message =  "User email cannot be null and blank ")
    private String email;
    private String password;
    private String phNo;
    private UserRole role;
}
