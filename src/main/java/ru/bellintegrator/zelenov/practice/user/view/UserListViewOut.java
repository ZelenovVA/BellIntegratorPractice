package ru.bellintegrator.zelenov.practice.user.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Объект пользователя для отправки клиенту
 */
@Data
@ApiModel
public class UserListViewOut {

    /**
     * Уникальный идентификатор пользователя
     */
    @ApiModelProperty(position = 1)
    private Long id;

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
}
