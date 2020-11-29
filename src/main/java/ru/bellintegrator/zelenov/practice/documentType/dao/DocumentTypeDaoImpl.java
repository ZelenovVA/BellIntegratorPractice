package ru.bellintegrator.zelenov.practice.documentType.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.documentType.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
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
    public DocumentType getDocTypeByDocCode(String docCode) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> query = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> documentTypeRoot = query.from(DocumentType.class);
        Predicate filter = criteriaBuilder.equal(documentTypeRoot.get("docCode"), docCode);
        query.select(documentTypeRoot).where(filter);
        TypedQuery<DocumentType> typedQuery = em.createQuery(query);
        return typedQuery.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocType(DocumentType documentType) {
        em.persist(documentType);
    }
}
