package ru.bellintegrator.zelenov.practice.view.documentType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View объект типа документа для отправки клиенту
 */
public class DocumentTypeView {

    /**
     * Код типа документа
     */
    @Size(max = 5)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String docCode;

    /**
     * Наименование типа документа
     */
    @Size(max = 150)
    @NotNull(message = "Данное поле не может быть пустым!")
    private String docName;
}
