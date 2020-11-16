package ru.bellintegrator.zelenov.practice.view.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserUpdateView {

    /**
     * Уникальный идентификатор пользователя
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    private Long id;

    /**
     * Офис, за которым закреплен пользователь
     */
    private Long officeId;

    /**
     * Имя
     */
    @Size(max = 50)
    @NotNull(message = "Данное поле не может быть пустым!")
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
    @NotNull(message = "Данное поле не может быть пустым!")
    private String position;

    /**
     * Телефон
     */
    @Size(max = 11)
    private String phone;

    /**
     * Наименование типа документа
     */
    @Size(max = 150)
    private String docName;

    /**
     * Номер документа
     */
    @Size(max = 10)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    private LocalDate docDate;

    /**
     * Код страны
     */
    @Size(max = 5)
    private String citizenshipCode;

    /**
     * Флаг идентификации
     */
    private boolean isIdentified;
}
