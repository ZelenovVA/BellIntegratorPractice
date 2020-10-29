package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users;
}
