package ru.bellintegrator.zelenov.practice.country.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.country.service.CountryService;
import ru.bellintegrator.zelenov.practice.country.view.CountryView;

import java.util.List;

/**
 * Контроллер для стран
 */
@RestController
@RequestMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Получение списка стран
     *
     * @return список стран
     */
    @PostMapping
    @ApiOperation(value = "Get all countries", httpMethod = "POST")
    public List<CountryView> getAllCountries() {
        return countryService.getAllCountries();
    }
}
