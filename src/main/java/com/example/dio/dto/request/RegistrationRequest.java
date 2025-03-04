package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegistrationRequest {

//    @NotNull
//    @NotBlank  both the annotation are cmbined in @NotEmpty
    @NotBlank(message =  "User name cannot be  blank ")
    @NotEmpty(message =  "User name cannot be null and blank ")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" , message = "User can only contain Alphabets , Number and UnderScore")
    private String userName ;



    @NotBlank(message =  "User email cannot be blank ")
    @NotNull(message =  "User email cannot be null ")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com", message = "Email must be a valid Gmail address")
    private String email;



    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z].*[a-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, at least two lowercase letters, at least one digit, and at least one special character (@$!%*?&)"
    )
    private String password;



    @NotNull(message = "phone number cannot be null")
    @NotBlank(message = "phone number cannot be blank")
    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Invalid Phone Number")
    private String phNo;



    private UserRole role;
}
