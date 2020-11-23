package ru.bellintegrator.zelenov.practice.service.country;

import ru.bellintegrator.zelenov.practice.view.country.CountryView;

import java.util.List;

/**
 * Сервисный слой для работы со списком гражданств
 */
public interface CountryService {

    /**
     * Получить список гражданств
     * @return список гражданств
     */
    List<CountryView> getAllCountries();
}
