package ru.bellintegrator.zelenov.practice.exception;

/**
 * Объект ошибки ненайденных данных для уведомления клиента
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
