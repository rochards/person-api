package com.rochards.personapi.exceptions;

import com.rochards.personapi.exceptions.types.PersonNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Field> fields = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {

            String message = error.getDefaultMessage();
            String fieldName = ((FieldError) error).getField();

            fields.add(new Field(fieldName, message));
        }

        var title = "One or more fields are invalid!";
        var exceptionMessage = new ExceptionMessage(status.value(), OffsetDateTime.now(), title, fields);

        return super.handleExceptionInternal(ex, exceptionMessage, headers, status, request);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request) {

        var status = HttpStatus.BAD_REQUEST;
        var exceptionMessage = new ExceptionMessage(status.value(), OffsetDateTime.now(), ex.getMessage(), null);

        return super.handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), status, request);
    }
}
