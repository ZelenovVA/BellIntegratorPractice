package ru.bellintegrator.zelenov.practice.organization.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * View объект списка организаций для отправки клиенту
 */
@Data
@ApiModel
public class OrganizationListViewOut {

    /**
     * Уникальный идентификатор организации
     */
    @ApiModelProperty(position = 1)
    private Long id;

    /**
     * Имя организации
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
