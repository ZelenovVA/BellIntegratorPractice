package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
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
     * Организация{@link Organization}, за которой закреплен офис
     */
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "organization_id")
    private Organization organization;


    /**
     * Список пользователей{@link User} офиса
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private Set<User> users=new HashSet<>();
}
