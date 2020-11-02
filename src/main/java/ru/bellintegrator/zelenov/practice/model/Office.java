package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Office")
public class Office extends BaseEntity {

    /**
     * Список пользователей{@link User} офиса
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Set<User> users;
}
