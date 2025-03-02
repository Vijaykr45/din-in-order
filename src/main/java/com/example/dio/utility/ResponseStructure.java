package com.example.dio.utility;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {

    private int status ;
    private String message;
    private T data ;


    public  static<T> ResponseStructure<T> create (int status , String message , T data ) {
        ResponseStructure <T>  response = new ResponseStructure<T> ();
        response.status = status;
        response.message = message ;
        response.data = data;

        return response;
    }
}
