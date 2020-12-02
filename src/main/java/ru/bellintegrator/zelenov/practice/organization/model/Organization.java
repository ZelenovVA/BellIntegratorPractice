package ru.bellintegrator.zelenov.practice.organization.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Организация
 */
@Entity
@Data
@Table(name = "Organization")
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(name = "inn", nullable = false, length = 12)
    private String inn;

    /**
     * КПП организации
     */
    @Column(name = "kpp", nullable = false, length = 9)
    private String kpp;

    /**
     * Адрес огранизации
     */
    @Column(name = "address", nullable = false, length = 150)
    private String address;

    /**
     * Контактный номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Флаг активности
     */
    @Column(name = "is_active")
    private Boolean isActive;
}
