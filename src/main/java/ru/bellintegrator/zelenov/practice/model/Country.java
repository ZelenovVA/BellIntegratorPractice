package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Гражданство пользователя {@link User}
 */
@Data
@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Код страны
     */
        @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name")
    private String citizenshipName;
}
