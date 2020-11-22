package ru.bellintegrator.zelenov.practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.office.Office;

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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getAllOffices(Office office) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery=builder.createQuery(Office.class);
        Root<Office> officeRoot=criteriaQuery.from(Office.class);
        //Фильтр по уникальному идентификатору организации
        Predicate filter=builder.equal(officeRoot.get("org_id"), office.getOrganization().getId());
        //Фильтр по имени
        if (office.getName()!=null&&office.getName().length()>0){
            filter=builder.and(filter, builder.like(officeRoot.get("name"), "%"+office.getName()+"%"));
        };
        //Фильтр по телефону
        if (office.getPhone()!=null&&office.getPhone().length()>0){
            filter=builder.and(filter, builder.like(officeRoot.get("phone"), "%"+office.getPhone()+""));
        };
        //Фильтр по активности
        if (office.getIsActive()!=null){
            if (office.getIsActive()){
                filter=builder.and(filter, builder.isTrue(officeRoot.get("isActive")));
            } else {
                filter=builder.and(filter, builder.isFalse(officeRoot.get("isActive")));
            }
        };
        criteriaQuery.select(officeRoot).where(filter);
        TypedQuery<Office> query=em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(Long officeId) {
        return em.find(Office.class, officeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }

    @Override
    public void removeOffice(Long officeId) {
        Office office=em.find(Office.class, officeId);
        if (office!=null){
            em.remove(office);
        }
    }
}
