package com.ss.org.cartService.common;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(final CustomException exception){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .errorCode(exception.getCode())
                .message(exception.getMessage())
                .build();
        ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ExceptionResponse> handleDataException(final DataAccessException dataAccessException){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(dataAccessException.getMessage())
                .build();
        ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}
