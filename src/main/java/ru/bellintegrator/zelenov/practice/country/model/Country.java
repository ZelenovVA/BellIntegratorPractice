package ru.bellintegrator.zelenov.practice.country.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.zelenov.practice.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Гражданство пользователя {@link User}
 */
@Data
@Entity
@Table(name = "Country")
@NoArgsConstructor
public class Country {

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
     * Код страны
     */
    @Column(name = "citizenship_code", length = 5, nullable = false)
    private String citizenshipCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name", length = 100, nullable = false)
    private String citizenshipName;
}
