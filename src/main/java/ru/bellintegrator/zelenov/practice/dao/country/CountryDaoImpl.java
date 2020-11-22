package ru.bellintegrator.zelenov.practice.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.country.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public void saveCountry(Country country) {
        em.persist(country);
    }
}
