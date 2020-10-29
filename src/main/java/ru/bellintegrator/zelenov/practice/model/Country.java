package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Гражданство пользователя {@link User}
 */
@Data
@Entity
@Table(name = "country")
public class Country {

    /**
     * Код страны
     */
    @Id
    @Column(name = "citizenship_code")
    private Integer countryCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name")
    private String citizenshipName;
}
