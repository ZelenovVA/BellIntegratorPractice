package ru.bellintegrator.zelenov.practice.dao.documentType;


import ru.bellintegrator.zelenov.practice.model.documentType.DocumentType;

import java.util.List;

/**
 * DAO для типов документов
 */
public interface DocumentTypeDao {
    /**
     * Получение списка всех типов документов
     * @return
     */
    List<DocumentType> getAllDocTypes();

    /**
     * Получение типа документа по уникальному идентификатору
     * @param id уникальный идентификатор документа
     * @return Тип документа, который соответствует уникальному идентификатору
     */
    DocumentType getDocTypeById(Long id);

    /**
     * Добавление типа документа
     * @param documentType тип документа, который нужно добавить
     */
    void saveDocType(DocumentType documentType);
}
