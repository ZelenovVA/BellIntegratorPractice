package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Тип документа, в соответствии с Приложением N 3
 * к Требованиям к оформлению
 * документов, представляемых
 * в регистрирующий орган
 */
@Data
@Entity
@Table(name = "documentType")
public class DocumentType {

    @Id
    @Column(name = "doc_code")
    private Long code;

    @Column(name = "doc_name")
    private String name;

}
