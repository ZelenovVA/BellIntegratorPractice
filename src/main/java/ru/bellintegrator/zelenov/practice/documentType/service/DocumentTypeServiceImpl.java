package ru.bellintegrator.zelenov.practice.documentType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.documentType.dao.DocumentTypeDao;
import ru.bellintegrator.zelenov.practice.documentType.model.DocumentType;
import ru.bellintegrator.zelenov.practice.documentType.view.DocumentTypeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDao documentTypeDao;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao documentTypeDao) {
        this.documentTypeDao = documentTypeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeView> getAllDocTypes() {
        return documentTypeDao
                .getAllDocTypes()
                .stream()
                .map(mapDocumentType())
                .collect(Collectors.toList());
    }

    private Function<DocumentType, DocumentTypeView> mapDocumentType() {
        return documentType -> {
            DocumentTypeView documentTypeView = new DocumentTypeView();
            documentTypeView.setCode(documentType.getDocCode());
            documentTypeView.setName(documentType.getDocName());
            return documentTypeView;
        };
    }
}
