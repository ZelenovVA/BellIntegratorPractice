package ru.bellintegrator.zelenov.practice.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Документ, удостоверяющий личность
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Document")
public class Document {

    /**
     * Номер документа
     */
    @Id
    @Column(name = "doc_number", nullable = false)
    private Long docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date", nullable = false)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private LocalDate docDate;

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
