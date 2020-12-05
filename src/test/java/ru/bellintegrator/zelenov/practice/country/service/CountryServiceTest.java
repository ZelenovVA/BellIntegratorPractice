package ru.bellintegrator.zelenov.practice.country.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.zelenov.practice.country.view.CountryView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void getAllCountries() throws Exception {
        assertThat(this.countryService.getAllCountries()).isNotNull();
        assertThat(this.countryService.getAllCountries().size()).isGreaterThan(0);
    }
}