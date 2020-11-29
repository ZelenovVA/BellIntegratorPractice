package ru.bellintegrator.zelenov.practice.documentType.dao;


import ru.bellintegrator.zelenov.practice.documentType.model.DocumentType;

import java.util.List;

/**
 * DAO для типов документов
 */
public interface DocumentTypeDao {
    /**
     * Получение списка всех типов документов
     *
     * @return
     */
    List<DocumentType> getAllDocTypes();

    /**
     * Получение типа документа по уникальному идентификатору
     *
     * @param id уникальный идентификатор документа
     * @return Тип документа, который соответствует уникальному идентификатору
     */
    DocumentType getDocTypeById(Long id);

    /**
     * Получение типа документа по коду
     *
     * @param docCode код документа
     * @return документ
     */
    DocumentType getDocTypeByDocCode(String docCode);

    /**
     * Добавление типа документа
     *
     * @param documentType тип документа, который нужно добавить
     */
    void saveDocType(DocumentType documentType);
}
