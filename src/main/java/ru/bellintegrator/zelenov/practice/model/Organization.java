package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Организация
 */

@Entity
@Data
@Table(name = "Organization")
public class Organization extends BaseEntity {

    /**
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(name="inn", nullable = false)
    private Long inn;

    /**
     * КПП организации
     */
    @Column(name = "kpp", nullable = false)
    private Long kpp;

    /**
     * Список офисов организации
     */
    @OneToMany
    @JoinColumn(name = "office_id")
    private List<Office> offices;

}
