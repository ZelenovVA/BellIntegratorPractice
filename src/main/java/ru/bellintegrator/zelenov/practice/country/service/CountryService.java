package ru.bellintegrator.zelenov.practice.country.service;

import ru.bellintegrator.zelenov.practice.country.view.CountryView;

import java.util.List;

/**
 * Сервисный слой для работы со списком гражданств
 */
public interface CountryService {

    /**
     * Получить список гражданств
     *
     * @return список гражданств
     */
    List<CountryView> getAllCountries();
}
