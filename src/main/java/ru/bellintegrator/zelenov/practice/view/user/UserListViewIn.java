package ru.bellintegrator.zelenov.practice.view.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий объект пользователя
 */
public class UserListViewIn {

    /**
     * Офис, за которым закреплен пользователь
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long officeId;

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

    /**
     * Код документа, удостоверяющего личность пользователя
     */
    @Size(max = 5)
    private String docCode;

    /**
     * Код гражданства пользователя
     */
    @Size(max = 5)
    private String citizenshipCode;
}
