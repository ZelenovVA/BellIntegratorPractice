package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

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
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Код типа документа
     */
    @Column(name = "doc_code", nullable = false)
    private Integer code;

    /**
     * Наименование типа документа
     */
    @Column(name = "doc_name", nullable = false, length = 100)
    private String name;

}
