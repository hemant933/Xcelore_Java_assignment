package com.example.demo.Exception;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
        String error = ex.getBindingResult()
                         .getFieldErrors()
                         .stream()
                         .map(field -> field.getField() + ": " + field.getDefaultMessage())
                         .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body("Validation error: " + error);
    }
}


