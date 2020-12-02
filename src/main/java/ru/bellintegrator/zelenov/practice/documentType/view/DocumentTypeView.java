package ru.bellintegrator.zelenov.practice.documentType.view;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект типа документа для отправки клиенту
 */
@Data
public class DocumentTypeView {

    /**
     * Наименование типа документа
     */
    @Size(max = 150)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String name;

    /**
     * Код типа документа
     */
    @Size(max = 5)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String code;

}
