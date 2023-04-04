package com.veronika.javaspringboot.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CarExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exceptionArgNotValidHandler(MethodArgumentNotValidException e) {
        ResponseEntity<String> response = new ResponseEntity<>(e.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        return response;
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> exceptionNotReadable(HttpMessageNotReadableException e){
//
//        ResponseEntity<String> tResponseEntity = new ResponseEntity<>(e);
//    }
}
