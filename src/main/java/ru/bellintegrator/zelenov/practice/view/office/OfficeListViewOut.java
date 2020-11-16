package ru.bellintegrator.zelenov.practice.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект офиса для отправки клиенту
 */
public class OfficeListViewOut {
    /**
     * уникальный идентификатор офиса
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long id;

    /**
     * Имя офиса
     */
    @Size(max = 50)
    private String name;

    /**
     * Флаг активности
     */
    private Boolean isActive;
}
