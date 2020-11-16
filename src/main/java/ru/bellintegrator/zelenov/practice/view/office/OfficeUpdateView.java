package ru.bellintegrator.zelenov.practice.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект для изменения
 */
public class OfficeUpdateView {

    /**
     * уникальный идентификатор офиса
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long id;

    /**
     * Имя офиса
     */
    @Size(max = 50)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String name;

    /**
     * Адрес
     */
    @Size(max = 150)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String address;

    /**
     * Контактный номер телефона
     */
    @Size(max = 11)
    private String phone;

    /**
     * Флаг активности
     */
    private Boolean isActive;
}
