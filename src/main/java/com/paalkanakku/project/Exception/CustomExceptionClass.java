package com.paalkanakku.project.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class CustomExceptionClass extends RuntimeException {

     private String message;
     private HttpStatus statusCode;

     public CustomExceptionClass(String message, HttpStatus statusCode){
          super(message);
          this.message = message;
          this.statusCode= statusCode;
     }

}
