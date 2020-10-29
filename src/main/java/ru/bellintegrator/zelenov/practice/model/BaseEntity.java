package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Родительский класс для подклассов Организация {@link Organization} и Офис {@link Office}
 */
@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    private String name;

    /**
     * Адрес
     */
    private String address;

    /**
     * Контактный номер телефона
     */
    private String phone;

    /**
     * Флаг активности
     */
    private boolean isActive;

}
