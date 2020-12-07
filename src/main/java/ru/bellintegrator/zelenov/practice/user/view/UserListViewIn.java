package ru.bellintegrator.zelenov.practice.user.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий объект пользователя
 */
@Data
@ApiModel
public class UserListViewIn {

    /**
     * Офис, за которым закреплен пользователь
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 1)
    private Long officeId;

    /**
     * Имя
     */
    @Size(max = 50)
    @ApiModelProperty(position = 2)
    private String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    @ApiModelProperty(position = 3)
    private String secondName;

    /**
     * Отчество
     */
    @Size(max = 50)
    @ApiModelProperty(position = 4)
    private String middleName;

    /**
     * Должность
     */
    @Size(max = 100)
    @ApiModelProperty(position = 5)
    private String position;

    /**
     * Код документа, удостоверяющего личность пользователя
     */
    @Size(max = 5)
    @ApiModelProperty(position = 6)
    private String docCode;

    /**
     * Код гражданства пользователя
     */
    @Size(max = 5)
    @ApiModelProperty(position = 7)
    private String citizenshipCode;
}
