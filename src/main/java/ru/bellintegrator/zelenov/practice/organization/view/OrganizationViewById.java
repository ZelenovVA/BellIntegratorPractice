package ru.bellintegrator.zelenov.practice.organization.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class OrganizationViewById {

    /**
     * Уникальный идентификатор организации
     */
    @NotNull(message = "Данное поле не может быть пустым!!!")
    private Long id;

    /**
     * Имя
     */
    @Size(max = 50)
    private String name;

    /**
     * Полное название организации
     */
    @Size(max = 100)
    private String fullName;

    /**
     * ИНН организации
     */
    @Size(max = 12)
    private String inn;

    /**
     * КПП организации
     */
    @Size(max = 9)
    private String kpp;

    /**
     * Адрес огранизации
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
