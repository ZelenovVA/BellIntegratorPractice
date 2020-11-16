package ru.bellintegrator.zelenov.practice.view.organization;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект для изменения
 */
@Data
public class OrganizationUpdateView {
    /**
     * Уникальный идентификатор организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long id;

    /**
     * Имя
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 50)
    private String name;

    /**
     * Полное название организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 100)
    private String fullName;

    /**
     * ИНН организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 12)
    private String inn;

    /**
     * КПП организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 9)
    private String kpp;

    /**
     * Адрес огранизации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
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
    private boolean isActive=true;
}
