package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Организация
 */

@Entity
@Data
@Table(name = "Organization")
@NoArgsConstructor
public class Organization extends BaseEntity {

    /**
     * Полное название организации
     */
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(name="inn", nullable = false, length = 12)
    private String inn;

    /**
     * КПП организации
     */
    @Column(name = "kpp", nullable = false, length = 9)
    private String kpp;

    /**
     * Список офисов{@link Office} организации
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Set<Office> offices;

}
