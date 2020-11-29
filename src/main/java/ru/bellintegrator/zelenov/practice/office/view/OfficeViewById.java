package ru.bellintegrator.zelenov.practice.office.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект для получения по уникальному идентификатору
 */
@Data
public class OfficeViewById {
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
