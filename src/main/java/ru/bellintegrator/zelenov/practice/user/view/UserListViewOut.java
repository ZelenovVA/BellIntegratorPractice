package ru.bellintegrator.zelenov.practice.user.view;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Объект пользователя для отправки клиенту
 */
@Data
public class UserListViewOut {

    /**
     * Уникальный идентификатор пользователя
     */
    private Long id;

    /**
     * Имя
     */
    @Size(max = 50)
    private String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Size(max = 50)
    private String middleName;

    /**
     * Должность
     */
    @Size(max = 100)
    private String position;
}
