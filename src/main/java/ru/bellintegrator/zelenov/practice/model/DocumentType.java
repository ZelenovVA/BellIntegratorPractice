package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import javax.persistence.*;

/**
 * Тип документа{@link Document}, в соответствии с Приложением N 3
 * к Требованиям к оформлению
 * документов, представляемых
 * в регистрирующий орган
 */
@Data
@Entity
@Table(name = "DocumentType")
@OptimisticLocking(type = OptimisticLockType.VERSION)
@NoArgsConstructor
public class DocumentType {

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
     * Код типа документа
     */
    @Column(name = "doc_code")
    private Integer code;

    /**
     * Наименование типа документа
     */
    @Column(name = "doc_name", length = 150)
    private String name;

}
