package com.example.demo.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PageNegativeException extends RuntimeException {
    public PageNegativeException(String message){
        super(message);
    }

    public PageNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

}
