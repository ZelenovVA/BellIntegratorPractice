package ru.bellintegrator.zelenov.practice.document.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.document.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager em;

    @Autowired
    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Document> getAllDocuments() {
        TypedQuery<Document> query = em.createQuery("SELECT d from Document d", Document.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getDocumentById(Long userId) {
        return em.find(Document.class, userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocument(Document document) {
        em.persist(document);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDocument(Document document) {
        em.merge(document);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void removeDocument(Long docId) {
        Document document = em.find(Document.class, docId);
        if (document != null) {
            em.remove(document);
        }
    }
}
