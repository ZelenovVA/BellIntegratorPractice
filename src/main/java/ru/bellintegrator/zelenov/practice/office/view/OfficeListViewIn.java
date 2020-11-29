package ru.bellintegrator.zelenov.practice.office.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект офиса
 */
@Data
public class OfficeListViewIn {
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
     * Котнтактный номер телефона офиса
     */
    @Size(max = 50)
    private String phone;

    /**
     * Флаг активности
     */
    private Boolean isActive;
}
