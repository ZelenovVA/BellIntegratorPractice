package ru.bellintegrator.zelenov.practice.successResponse;

import lombok.Getter;

/**
 * Объект успешного довабления или изменения данных для отправки клиенту
 */
@Getter
public class SuccessView {
    private final String result="success";
}
