package ru.bellintegrator.zelenov.practice.user.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

/**
 * Объект пользователя для сохранения
 */
@Data
public class UserSaveView {

    /**
     * Офис, за которым закреплен пользователь
     */
    @NotNull(message = "Данное поле не может быть пустым!")
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
     * Код типа документа
     */
    @Size(max = 5)
    private String docCode;

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
    private Date docDate;

    /**
     * Код страны
     */
    @Size(max = 5)
    private String citizenshipCode;

    /**
     * Флаг идентификации
     */
    private Boolean isIdentified;
}
