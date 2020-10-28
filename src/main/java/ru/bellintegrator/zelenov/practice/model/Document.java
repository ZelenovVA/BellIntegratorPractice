package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Документ, удостоверяющий личность
 */
@Data
@Entity
@Table(name = "document")
public class Document {

    /**
     * Номер документа
     */
    @Id
    @Column(name = "doc_number")
    private Long docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date")
    private Date docDate;

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
