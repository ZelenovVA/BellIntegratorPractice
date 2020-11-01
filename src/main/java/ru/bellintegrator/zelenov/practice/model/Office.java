package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Data
@Entity
@Table(name = "Office")
public class Office extends BaseEntity {

    /**
     * Список пользователей в офисе
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Set<User> users;
}
