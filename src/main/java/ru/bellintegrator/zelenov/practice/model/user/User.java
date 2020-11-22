package ru.bellintegrator.zelenov.practice.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.zelenov.practice.model.country.Country;
import ru.bellintegrator.zelenov.practice.model.document.Document;
import ru.bellintegrator.zelenov.practice.model.office.Office;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Должность
     */
    @Column(name = "position", nullable = false, length = 100)
    private String position;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Флаг идентификации
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Офис, за которым закреплен сотрудник
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    /**
     * Документ, удовстоверяющий личность пользователя
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL, optional = false)
    private Document userDocument;

    /**
     * Гражданство пользователя
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
