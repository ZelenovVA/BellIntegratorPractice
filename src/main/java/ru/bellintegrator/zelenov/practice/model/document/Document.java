package ru.bellintegrator.zelenov.practice.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.zelenov.practice.model.documentType.DocumentType;
import ru.bellintegrator.zelenov.practice.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.time.LocalDate;

/**
 * Документ, удостоверяющий личность
 */
@Data
@Entity
@Table(name = "Document")
@NoArgsConstructor
public class Document {

    @Id
    private Long id;

    /**
     * Службеное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя документа
     */
    @Column(name = "doc_name", length = 50)
    private String docName;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 10)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private LocalDate docDate;

    /**
     * Пользователь, которому принадлежит документ
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Тип документа, в соответствии с Приложением N 3
     * к Требованиям к оформлению
     * документов, представляемых
     * в регистрирующий орган
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id", nullable = false)
    private DocumentType docType;
}
