package com.herokuapp.api.accounts.sample.controller.advice;

import com.herokuapp.api.accounts.sample.exceptions.SystemException;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CatchAllExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleAllException(RuntimeException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<?> handleSystemException(SystemException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }
}
