package ru.bellintegrator.zelenov.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.organization.Organization;

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
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getAllOrganizations(Organization organization) {
        CriteriaBuilder builder=em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery=builder.createQuery(Organization.class);
        Root<Organization> organizationRoot=criteriaQuery.from(Organization.class);
        //Фильтр по имени
        Predicate filter=builder.like(organizationRoot.get("name"), "%"+organization.getName()+"%");
        //Фильтр по ИНН
        if (organization.getInn()!=null&&organization.getInn().length()>0){
            filter=builder.and(filter, builder.equal(organizationRoot.get("inn"), organization.getInn()));
        };
        //Фильтр по активности
        if (organization.getIsActive()!=null){
                filter=builder.and(filter, builder.equal(organizationRoot.get("isActive"),organization.getIsActive()));
        };
        criteriaQuery.select(organizationRoot).where(filter);
        TypedQuery<Organization> query=em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationById(Long organizationId) {
        return em.find(Organization.class, organizationId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(Organization organization) {
        em.merge(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOrganization(Long id) {
        Organization organization=em.find(Organization.class, id);
        if (organization!=null){
            em.remove(organization);
        }
    }
}
