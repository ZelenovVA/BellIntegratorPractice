package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Документ, удостоверяющий личность
 */
@Data
@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Номер документа
     */
    @Column(name = "doc_number")
    private String docNumber;

    /**
     * Службеное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private LocalDate docDate;

    /**
     * Прользователь, которому принадлежит документ
     */
    @OneToOne(mappedBy = "document", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private User user;

    /**
     * Тип документа, в соответствии с Приложением N 3
     * к Требованиям к оформлению
     * документов, представляемых
     * в регистрирующий орган
     */
    @OneToOne
    @JoinColumn(name = "doc_type_code")
    private DocumentType docType;
}
