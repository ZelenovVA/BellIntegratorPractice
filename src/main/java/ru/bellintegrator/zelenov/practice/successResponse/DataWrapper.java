package ru.bellintegrator.zelenov.practice.successResponse;

import lombok.Setter;

/**
 * Обертка для отправки результатов запросов клиенту
 */
@Setter
public class DataWrapper {
    private Object data;
}
