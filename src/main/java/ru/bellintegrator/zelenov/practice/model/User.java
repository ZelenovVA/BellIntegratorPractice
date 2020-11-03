package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@OptimisticLocking(type = OptimisticLockType.VERSION)
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
    private boolean isIdentified;

    /**
     * Офис{@link Office}, за которым закреплен пользователь
     */
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Документ{@link Document}, удостоверяющий личность
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Document document;

    /**
     * Гражданство{@link Country}
     */
    @OneToMany
    @JoinColumn(name = "country_code")
    private Set<Country> countries=new HashSet<>();
}
