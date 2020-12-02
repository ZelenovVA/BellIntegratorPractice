package ru.bellintegrator.zelenov.practice.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.country.dao.CountryDao;
import ru.bellintegrator.zelenov.practice.country.model.Country;
import ru.bellintegrator.zelenov.practice.country.view.CountryView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> getAllCountries() {
        return countryDao
                .getAllCountries()
                .stream()
                .map(mapCountry())
                .collect(Collectors.toList());
    }

    private Function<Country, CountryView> mapCountry() {
        return country -> {
            CountryView countryView = new CountryView();
            countryView.setCode(country.getCitizenshipCode());
            countryView.setName(country.getCitizenshipName());
            return countryView;
        };
    }
}
