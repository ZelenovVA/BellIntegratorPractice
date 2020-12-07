package ru.bellintegrator.zelenov.practice.office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект офиса
 */
@Data
@ApiModel
public class OfficeListViewIn {
    /**
     * уникальный идентификатор организации, за которой закреплен офис
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 1)
    private Long orgId;

    /**
     * Имя офиса
     */
    @Size(max = 50)
    @ApiModelProperty(position = 2)
    private String name;

    /**
     * Котнтактный номер телефона офиса
     */
    @Size(max = 50)
    @ApiModelProperty(position = 3)
    private String phone;

    /**
     * Флаг активности
     */
    @ApiModelProperty(position = 4)
    private Boolean isActive;
}
