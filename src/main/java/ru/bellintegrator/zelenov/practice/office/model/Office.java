package ru.bellintegrator.zelenov.practice.office.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Офис
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Office")
public class Office {

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
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", length = 150)
    private String address;

    /**
     * Контактный номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Флаг активности
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Организация, за которой закреплен офис
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
}
