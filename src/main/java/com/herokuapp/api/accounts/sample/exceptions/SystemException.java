package com.herokuapp.api.accounts.sample.exceptions;

import org.springframework.http.HttpStatus;

public class SystemException extends RuntimeException {
    public final HttpStatus httpStatus;

    public SystemException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
