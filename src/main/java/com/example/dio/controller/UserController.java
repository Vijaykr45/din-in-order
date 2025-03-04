package com.example.dio.controller;


import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.utility.FieldErrorResponse;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
@Tag(name = "User Controller", description = "Collection of API Endpoints for User Management.")

public class UserController {

    private  final UserService userService;


    @PostMapping("/register")
    @Operation(
            description = """
                    This API endpoint is used to register a new user.
                    The endpoint requires the user to select one of the specified roles along with other details.
                    """,
            responses = {
                    @ApiResponse(responseCode = "201", description = "User Created"),
                    @ApiResponse(responseCode = "401", description = "Invalid User", content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            }
    )
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserResponse response = userService.registerUser(registrationRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", response);
    }



    @GetMapping("/user/{userId}")
    @Operation(
            description = """
                    This API endpoint is used to find user by  userId.
                    """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "User Found"),
                    @ApiResponse(responseCode = "401", description = "User Not Found", content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            }
    )
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable Long userId) {
        UserResponse response = userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Found", response);
    }




    @PutMapping("/users/{userId}")
    @Operation(
            description = """
                    This API endpoint is used to Update  a existing user.
                    """,
            responses = {
                    @ApiResponse(responseCode = "201", description = "User Updated"),
                    @ApiResponse(responseCode = "401", description = "User Not Found") ,
                    @ApiResponse(responseCode = "401", description = "Invalid Input Data" , content = {
                            @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                    })
            }
    )
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserBYId(@RequestBody UserRequest userRequest, @PathVariable Long userId) {
         UserResponse response = userService.updateUserById(userRequest, userId);
        return ResponseBuilder.success(HttpStatus.OK , "User Updated " , response);
    }

}
