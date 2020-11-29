package ru.bellintegrator.zelenov.practice.documentType.service;

import ru.bellintegrator.zelenov.practice.documentType.view.DocumentTypeView;

import java.util.List;

/**
 * Сервисный слой для работы со списком типов документов
 */
public interface DocumentTypeService {

    /**
     * Получить список типов документов
     *
     * @return список типов документов
     */
    List<DocumentTypeView> getAllDocTypes();
}
