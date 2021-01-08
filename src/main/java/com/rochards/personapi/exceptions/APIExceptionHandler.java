package com.rochards.personapi.exceptions;

import com.rochards.personapi.exceptions.types.PersonNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request) {

        var status = HttpStatus.BAD_REQUEST;
        var message = new ExceptionMessage(status.value(), OffsetDateTime.now(), ex.getMessage(), null);

        return super.handleExceptionInternal(ex, message, new HttpHeaders(), status, request);
    }
}
