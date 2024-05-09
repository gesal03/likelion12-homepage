package com.homepage.likelion.util.exception;

import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomApiResponse<?>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 1. errorMessage
        String errorMessage = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        // 2. CustomApiResponse
        CustomApiResponse<Object> responseBody = CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), errorMessage);
        // 3. ResponseEntity
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseBody);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomApiResponse<?>> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        // 1. errorMessage
        String errorMessage = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));
        // 2. CustomApiResponse
        CustomApiResponse<Object> responseBody = CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), errorMessage);
        // 3. ResponseEntity
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseBody);
    }
}
