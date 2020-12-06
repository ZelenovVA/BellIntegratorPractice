package ru.bellintegrator.zelenov.practice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().stream().forEach(objectError -> {
            String name = objectError.getObjectName();
            String message = objectError.getDefaultMessage();
            errors.put(name, message);
        });
        logger.debug(errors + " .Error code: " + HttpStatus.BAD_REQUEST);
        ErrorView errorView = new ErrorView();
        errorView.setError(errors);
        return new ResponseEntity<>(errorView, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorView dataNotFound(DataNotFoundException e) {
        logger.debug(e.getMessage() + ". Error code: " + HttpStatus.NOT_FOUND);
        ErrorView errorView = new ErrorView();
        errorView.setError(e.getMessage() + ". Error code: " + HttpStatus.NOT_FOUND);
        return errorView;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView somethingWrong(Exception e) {
        logger.debug(e.getMessage() + ". Error code: " + HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorView errorView = new ErrorView();
        errorView.setError("Some troubles on the server side. Error code: " + HttpStatus.INTERNAL_SERVER_ERROR);
        return errorView;
    }
}
