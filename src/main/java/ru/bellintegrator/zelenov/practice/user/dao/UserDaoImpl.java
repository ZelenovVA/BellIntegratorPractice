package ru.bellintegrator.zelenov.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.document.model.Document;
import ru.bellintegrator.zelenov.practice.user.model.User;

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
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> getAllUsers(User user) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        Root<Document> documentRoot = criteriaQuery.from(Document.class);
        //Фильтр по уникальному идентификатору офиса
        Predicate filter = builder.equal(userRoot.get("office").get("id"), user.getOffice().getId());
        //Фильтр по имени
        if (user.getFirstName() != null && user.getFirstName().length() > 0) {
            filter = builder.and(filter, builder.like(userRoot.get("firstName"), "%" + user.getFirstName() + ""));
        }
        ;
        //Фильтр по фамилии
        if (user.getSecondName() != null && user.getSecondName().length() > 0) {
            filter = builder.and(filter, builder.like(userRoot.get("secondName"), "%" + user.getSecondName() + ""));
        }
        ;
        //Фильтр по отчеству
        if (user.getMiddleName() != null && user.getMiddleName().length() > 0) {
            filter = builder.and(filter, builder.like(userRoot.get("middleName"), "%" + user.getMiddleName() + ""));
        }
        ;
        //Фильтр по должности
        if (user.getPosition() != null && user.getPosition().length() > 0) {
            filter = builder.and(filter, builder.like(userRoot.get("position"), "%" + user.getPosition() + ""));
        }
        ;
        //Фильтр по коду документа
        if (user.getUserDocument().getDocType().getDocCode() != null && user.getUserDocument().getDocType().getDocCode().length() > 0) {
            filter = builder.and(filter,
                    builder.like(userRoot.get("userDocument").get("documentType").get("docCode"),
                            "%" + user.getUserDocument().getDocType().getDocCode() + "%"));
        }
        //Фильтр по коду гражданству
        if (user.getCountry().getCitizenshipCode() != null && user.getCountry().getCitizenshipCode().length() > 0) {
            filter = builder.and(filter, builder.like(userRoot.get("country").get("citizenshipCode"), "%" + user.getCountry().getCitizenshipCode() + "%"));
        }
        ;

        criteriaQuery.select(userRoot).where(filter);
        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public User getUserById(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(Long userId) {
        User user = em.find(User.class, userId);
        if (user != null) {
            em.remove(user);
        }
    }
}
