package com.nihil.springintro.controllers.exceptions;

import com.nihil.springintro.services.exceptions.ControllerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> ControllerNotFound(ControllerNotFoundException e, HttpServletRequest req){
        String error = "Endpoint not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
