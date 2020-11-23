package ru.bellintegrator.zelenov.practice.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.service.country.CountryService;
import ru.bellintegrator.zelenov.practice.view.country.CountryView;

import java.util.List;

/**
 * Контроллер для стран
 */
@RestController
@RequestMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Получение списка стран
     * @return список стран
     */
    @PostMapping
    public List<CountryView> getAllCountries(){
       return countryService.getAllCountries();
    }
}
