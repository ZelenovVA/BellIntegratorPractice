package ru.bellintegrator.zelenov.practice.organization.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Входящий view объект для изменения
 */
@Data
@ApiModel
public class OrganizationUpdateView {
    /**
     * Уникальный идентификатор организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @ApiModelProperty(position = 1)
    private Long id;

    /**
     * Имя
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 50)
    @ApiModelProperty(position = 2)
    private String name;

    /**
     * Полное название организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 100)
    @ApiModelProperty(position = 3)
    private String fullName;

    /**
     * ИНН организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 12)
    @ApiModelProperty(position = 4)
    private String inn;

    /**
     * КПП организации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 9)
    @ApiModelProperty(position = 5)
    private String kpp;

    /**
     * Адрес огранизации
     */
    @NotNull(message = "Данное поле не может быть пустым!")
    @Size(max = 150)
    @ApiModelProperty(position = 6)
    private String address;

    /**
     * Контактный номер телефона
     */
    @Size(max = 11)
    @ApiModelProperty(position = 7)
    private String phone;

    /**
     * Флаг активности
     */
    @ApiModelProperty(position = 8)
    private Boolean isActive;
}
