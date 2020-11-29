package ru.bellintegrator.zelenov.practice.organization.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект для списка организаций
 */
@Data
public class OrganizationListViewIn {

    /**
     * Имя организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 50)
    private String name;

    /**
     * ИНН организации
     */
    @Size(max = 9)
    private String inn;

    /**
     * Флаг активности
     */
    private Boolean isActive = true;
}
