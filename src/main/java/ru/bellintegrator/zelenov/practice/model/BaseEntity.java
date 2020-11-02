package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Родительский класс для подклассов Организация {@link Organization} и Офис {@link Office}
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {

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
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    /**
     * Контактный номер телефона
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Флаг активности
     */
    @Column(name = "is_active")
    private boolean isActive=true;

}
