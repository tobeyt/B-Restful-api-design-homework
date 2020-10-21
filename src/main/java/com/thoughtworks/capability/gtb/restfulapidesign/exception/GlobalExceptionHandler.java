package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleException(StudentException exception) {
        return new Error(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
