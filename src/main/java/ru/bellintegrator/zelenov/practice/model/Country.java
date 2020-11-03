package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

/**
 * Гражданство пользователя {@link User}
 */
@Data
@Entity
@Table(name = "Country")
@OptimisticLocking(type = OptimisticLockType.VERSION)
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
        @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name", length = 100)
    private String citizenshipName;
}
