package ru.bellintegrator.zelenov.practice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "doc_code", nullable = false)
    private Integer code;

    @Column(name = "doc_name", nullable = false, length = 100)
    private String name;

}
