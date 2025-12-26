package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public void handleUnsupportedMediaType() {
        throw new RuntimeException("Unsupported media type");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void handleBadMethod() {
        throw new RuntimeException("Method not supported");
    }

    @ExceptionHandler(RuntimeException.class)
    public org.springframework.http.ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return new org.springframework.http.ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
