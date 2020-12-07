package ru.bellintegrator.zelenov.practice.office.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект для получения по уникальному идентификатору
 */
@Data
@ApiModel
public class OfficeViewById {
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
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 2)
    private String name;

    /**
     * Адрес
     */
    @Size(max = 150)
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 3)
    private String address;

    /**
     * Контактный номер телефона
     */
    @Size(max = 11)
    @ApiModelProperty(position = 4)
    private String phone;

    /**
     * Флаг активности
     */
    @ApiModelProperty(position = 5)
    private Boolean isActive;
}
