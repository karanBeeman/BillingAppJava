package com.paalkanakku.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {



        @ExceptionHandler(value = CustomExceptionClass.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ResponseEntity<Object> handleException(CustomExceptionClass ex)
        {
           return new ResponseEntity<Object>("Already bill available for this hotel on this date, please check in todays bill",
                   HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = CannotUpdateException.class)
        @ResponseStatus(HttpStatus.FORBIDDEN)
        public ResponseEntity<Object> handleException(CannotUpdateException ex)
        {
                return new ResponseEntity<Object>("Not updated Properly",
                        HttpStatus.FORBIDDEN);
        }

}
