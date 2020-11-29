package ru.bellintegrator.zelenov.practice.office.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект для сохранения
 */
@Data
public class OfficeSaveView {
    /**
     * уникальный идентификатор организации, за которой закреплен офис
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long orgId;

    /**
     * Имя офиса
     */
    @Size(max = 50)
    private String name;

    /**
     * Адрес
     */
    @Size(max = 150)
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
