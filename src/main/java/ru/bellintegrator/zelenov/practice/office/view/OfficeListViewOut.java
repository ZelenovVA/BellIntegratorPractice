package ru.bellintegrator.zelenov.practice.office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект офиса для отправки клиенту
 */
@Data
@ApiModel
public class OfficeListViewOut {
    /**
     * уникальный идентификатор офиса
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 1)
    private Long id;

    /**
     * Имя офиса
     */
    @Size(max = 50)
    @ApiModelProperty(position = 2)
    private String name;

    /**
     * Флаг активности
     */
    @ApiModelProperty(position = 3)
    private Boolean isActive;
}
