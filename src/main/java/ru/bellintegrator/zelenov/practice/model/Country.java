package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Гражданство пользователя {@link User}
 */
@Data
@Entity
@Table(name = "Country")
public class Country {

    /**
     * Код страны
     */
    @Id
    @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name")
    private String citizenshipName;
}
