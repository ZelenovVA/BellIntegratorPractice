package ru.bellintegrator.zelenov.practice.service.documentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.dao.documentType.DocumentTypeDao;
import ru.bellintegrator.zelenov.practice.model.documentType.DocumentType;
import ru.bellintegrator.zelenov.practice.view.documentType.DocumentTypeView;

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

    private Function<DocumentType, DocumentTypeView> mapDocumentType(){
        return documentType -> {
            DocumentTypeView documentTypeView=new DocumentTypeView();
            documentTypeView.setDocCode(documentType.getDocCode());
            documentTypeView.setDocName(documentType.getDocName());
            return documentTypeView;
        };
    }
}
