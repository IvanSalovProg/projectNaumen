package com.example.ATM.dto;

import java.util.List;

public class RequestValidationErrorDto {

    List<FieldValidationErrorDto> errors;

    public RequestValidationErrorDto(List<FieldValidationErrorDto> errors) {
        this.errors = errors;
    }

    public List<FieldValidationErrorDto> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldValidationErrorDto> errors) {
        this.errors = errors;
    }
}
