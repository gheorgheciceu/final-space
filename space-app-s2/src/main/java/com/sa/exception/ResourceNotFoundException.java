package com.sa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message, Object... args ){
        super(MessageFormat.format(message,args));
    }
}
