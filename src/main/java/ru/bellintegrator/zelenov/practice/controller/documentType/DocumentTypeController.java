package ru.bellintegrator.zelenov.practice.controller.documentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.service.documentType.DocumentTypeService;
import ru.bellintegrator.zelenov.practice.view.documentType.DocumentTypeView;

import java.util.List;

/**
 * Контроллер для типа документа, удостоверяющего личность
 */
@RestController
@RequestMapping(value = "/api/docs", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    /**
     * Получение списка типов документа
     * @return список типов документов
     */
    @PostMapping
    public List<DocumentTypeView> getAllDocTypes(){
        return documentTypeService.getAllDocTypes();
    }
}
