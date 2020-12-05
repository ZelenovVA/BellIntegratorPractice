package ru.bellintegrator.zelenov.practice.country.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class CountryDaoTest {

    @Autowired
    private CountryDao countryDao;

    @Test
    void getAllCountries() {
        assertThat(this.countryDao.getAllCountries()).isNotNull();
        assertThat(this.countryDao.getAllCountries().size()).isGreaterThan(0);
    }

    @Test
    void getCountryById() {
        assertThat(this.countryDao.getCountryById(1L).getCitizenshipCode()).isEqualTo("643");
    }

    @Test
    void getCountryByCitizenshipCode() {
        assertThat(this.countryDao.getCountryByCitizenshipCode("643").getCitizenshipName()).isEqualTo("Российская Федерация");
    }
}