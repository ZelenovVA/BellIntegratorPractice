package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * Должность
     */
    @Column(name = "position", nullable = false, length = 100)
    private String position;

    /**
     * Телефон
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Флаг идентификации
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Документ, удостоверяющий личность
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Document document;

    /**
     * Гражданство
     */
    @OneToMany
    @JoinColumn(name = "country_code")
    private Set<Country> countries;
}
