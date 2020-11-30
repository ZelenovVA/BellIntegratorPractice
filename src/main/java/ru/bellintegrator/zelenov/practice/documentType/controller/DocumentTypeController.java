package ru.bellintegrator.zelenov.practice.documentType.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.documentType.service.DocumentTypeService;
import ru.bellintegrator.zelenov.practice.documentType.view.DocumentTypeView;

import java.util.List;

/**
 * Контроллер для типа документа, удостоверяющего личность
 */
@RestController
@RequestMapping(value = "/api/docs", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Document type")
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    /**
     * Получение списка типов документа
     *
     * @return список типов документов
     */
    @PostMapping
    @ApiOperation(value = "Get all documents", httpMethod = "POST")
    public List<DocumentTypeView> getAllDocTypes() {
        return documentTypeService.getAllDocTypes();
    }
}
