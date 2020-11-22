package ru.bellintegrator.zelenov.practice.dao.document;

import ru.bellintegrator.zelenov.practice.model.document.Document;

import java.util.List;

/**
 * DAO для работы с документом пользователя
 */
public interface DocumentDao {
    /**
     * Получение списка всех документов
     * @return список документов
     */
    List<Document> getAllDocuments();

    /**
     * Получение документа пользователя по уникальному идентификатору
     * @param userId уникальный идентификатор пользователя
     * @return документ, соответствующий уникальному идентификатору пользователя
     */
    Document getDocumentById(Long userId);

    /**
     * Сохранение документа пользователя
     * @param document новый документ пользователя
     */
    void saveDocument(Document document);

    /**
     * Изменение документа пользователя
     * @param document документ пользователя
     */
    void updateDocument(Document document);

    /**
     * Удаление документа пользователя
     * @param docId уникальный идентифиткатор пользователя
     */
    void removeDocument(Long docId);
}
