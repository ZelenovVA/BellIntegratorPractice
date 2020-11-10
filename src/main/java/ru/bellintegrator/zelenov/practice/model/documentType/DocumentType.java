package ru.bellintegrator.zelenov.practice.model.documentType;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.zelenov.practice.model.document.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Тип документа{@link Document}, в соответствии с Приложением N 3
 * к Требованиям к оформлению
 * документов, представляемых
 * в регистрирующий орган
 */
@Data
@Entity
@Table(name = "DocumentType")
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
    @Column(name = "doc_code", length = 5, nullable = false)
    private String code;

    /**
     * Наименование типа документа
     */
    @Column(name = "doc_name", length = 150, nullable = false)
    private String name;
}
