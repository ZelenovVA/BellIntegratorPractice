package ru.bellintegrator.zelenov.practice.successResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * Обертка для отправки результатов запросов клиенту
 */
@Setter
@Getter
public class DataWrapper {
    private Object data;
}
