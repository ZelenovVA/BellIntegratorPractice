package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;

import javax.persistence.*;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
@Data
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
    @Column(name = "first_name", nullable = false)
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
    @Column(name = "position", nullable = false)
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
     * Офис организации, где работает пользователь
     */
    @OneToOne
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Документ, удостоверяющий личность
     */
    @OneToOne
    @JoinColumn(name = "doc_number")
    private Document document;

    /**
     * Гражданство
     */
    @OneToOne
    @JoinColumn(name = "country_code")
    private Country country;

}
