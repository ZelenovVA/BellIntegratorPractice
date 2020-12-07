package ru.bellintegrator.zelenov.practice.user.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Объект пользователя для изменения
 */
@Data
@ApiModel
public class UserUpdateView {

    /**
     * Уникальный идентификатор пользователя
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 1)
    private Long id;

    /**
     * Офис, за которым закреплен пользователь
     */
    @ApiModelProperty(position = 2)
    private Long officeId;

    /**
     * Имя
     */
    @Size(max = 50)
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 3)
    private String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    @ApiModelProperty(position = 4)
    private String secondName;

    /**
     * Отчество
     */
    @Size(max = 50)
    @ApiModelProperty(position = 5)
    private String middleName;

    /**
     * Должность
     */
    @Size(max = 100)
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 6)
    private String position;

    /**
     * Телефон
     */
    @Size(max = 11)
    @ApiModelProperty(position = 7)
    private String phone;

    /**
     * Наименование типа документа
     */
    @Size(max = 150)
    @ApiModelProperty(position = 8)
    private String docName;

    /**
     * Номер документа
     */
    @Size(max = 10)
    @ApiModelProperty(position = 9)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    @ApiModelProperty(position = 10)
    private Date docDate;

    /**
     * Код страны
     */
    @Size(max = 5)
    @ApiModelProperty(position = 11)
    private String citizenshipCode;

    /**
     * Флаг идентификации
     */
    @ApiModelProperty(position = 12)
    private Boolean isIdentified;
}
