package com.sa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleNotFound(RuntimeException ex, WebRequest request) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }


    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    protected ErrorResponse handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
    }

}
