package ru.bellintegrator.zelenov.practice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ErrorView dataNotFound(DataNotFoundException e) {
        ErrorView errorView = new ErrorView();
        errorView.setError(e.getMessage());
        return errorView;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorView wrongRequest(ConstraintViolationException e) {
        ErrorView errorView = new ErrorView();
        errorView.setError("Параметры запроса невалидны");
        return errorView;
    }

    @ExceptionHandler(Exception.class)
    public ErrorView somethingWrong(Exception e) {
        ErrorView errorView = new ErrorView();
        errorView.setError("Some troubles on the server side");
        return errorView;
    }
}
