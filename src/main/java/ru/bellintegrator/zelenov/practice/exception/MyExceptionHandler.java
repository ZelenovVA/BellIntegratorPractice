package ru.bellintegrator.zelenov.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorView dataNotFound(DataNotFoundException e) {
        ErrorView errorView = new ErrorView();
        errorView.setError(e.getMessage());
        return errorView;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorView wrongRequest(ConstraintViolationException e) {
        ErrorView errorView = new ErrorView();
        errorView.setError("Параметры запроса невалидны");
        return errorView;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorView somethingWrong(Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.setError("Some troubles on the server side");
        return errorView;
    }
}
