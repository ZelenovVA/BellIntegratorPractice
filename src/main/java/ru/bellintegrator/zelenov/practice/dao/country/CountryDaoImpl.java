package ru.bellintegrator.zelenov.practice.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.country.Country;

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
public class CountryDaoImpl implements CountryDao {
    private EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> getAllCountries() {
        TypedQuery<Country> query=em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country getCountryById(Long id) {
        return em.find(Country.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country getCountryByCitizenshipCode(String citizenshipCode) {
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<Country> query=criteriaBuilder.createQuery(Country.class);
        Root<Country> countryRoot=query.from(Country.class);
        Predicate filter=criteriaBuilder.equal(countryRoot.get("citizenshipCode"), citizenshipCode);
        query.select(countryRoot).where(filter);
        TypedQuery<Country> typedQuery=em.createQuery(query);
        return typedQuery.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCountry(Country country) {
        em.persist(country);
    }
}
