package ru.bellintegrator.zelenov.practice.dao.documentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.documentType.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {
    private EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentType> getAllDocTypes() {
        TypedQuery<DocumentType> query=em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getDocTypeById(Long id) {
        return em.find(DocumentType.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocType(DocumentType documentType) {
        em.persist(documentType);
    }
}
