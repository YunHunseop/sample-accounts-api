package com.herokuapp.api.accounts.sample.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
    public final HttpStatus httpStatus;

    public ValidationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
