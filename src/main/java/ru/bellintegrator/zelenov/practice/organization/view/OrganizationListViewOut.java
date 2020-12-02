package ru.bellintegrator.zelenov.practice.organization.view;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * View объект списка организаций для отправки клиенту
 */
@Data
public class OrganizationListViewOut {

    /**
     * Уникальный идентификатор организации
     */
    private Long id;

    /**
     * Имя организации
     */
    @Size(max = 50)
    private String name;

    /**
     * Флаг активности
     */
    private Boolean isActive;
}
