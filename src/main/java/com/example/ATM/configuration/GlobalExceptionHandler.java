package com.example.ATM.configuration;

import com.example.ATM.dto.FieldValidationErrorDto;
import com.example.ATM.dto.RequestValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<FieldValidationErrorDto> errors = ex.getFieldErrors().stream()
                .map(e -> new FieldValidationErrorDto(e.getField(), e.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestValidationErrorDto(errors));
    }
}
