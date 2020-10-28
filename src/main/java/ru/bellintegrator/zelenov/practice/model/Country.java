package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Гражданство пользователя
 */
@Data
@Entity
@Table(name = "country")
public class Country {

    /**
     * Код страны
     */
    @Id
    @Column(name = "country_code")
    private Integer countryCode;

    /**
     * Название страны
     */
    @Column(name = "country_name")
    private String countryName;
}
