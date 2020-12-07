package ru.bellintegrator.zelenov.practice.organization.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект для списка организаций
 */
@Data
@ApiModel
public class OrganizationListViewIn {

    /**
     * Имя организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 50)
    @ApiModelProperty(position = 1)
    private String name;

    /**
     * ИНН организации
     */
    @Size(max = 9)
    @ApiModelProperty(position = 2)
    private String inn;

    /**
     * Флаг активности
     */
    @ApiModelProperty(position = 3)
    private Boolean isActive;
}
