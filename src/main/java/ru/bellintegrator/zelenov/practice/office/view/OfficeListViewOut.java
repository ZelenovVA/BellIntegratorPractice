package ru.bellintegrator.zelenov.practice.office.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект офиса для отправки клиенту
 */
@Data
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
