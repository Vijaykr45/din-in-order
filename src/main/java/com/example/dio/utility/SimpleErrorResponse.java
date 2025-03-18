package com.example.dio.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Getter
public class SimpleErrorResponse {
    private String type ;
    private int status ;  // 404
    private String message ;  //failed to update the user , the user  is not found by the given request
}
