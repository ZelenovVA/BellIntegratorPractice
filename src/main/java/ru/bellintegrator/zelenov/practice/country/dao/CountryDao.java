package ru.bellintegrator.zelenov.practice.country.dao;

import ru.bellintegrator.zelenov.practice.country.model.Country;

import java.util.List;

/**
 * DAO для справичника стран, гражданином которых является пользователь
 */
public interface CountryDao {
    /**
     * Получение списка стран
     *
     * @return список стран
     */
    List<Country> getAllCountries();

    /**
     * Получение страны по уникальному идентификатору
     *
     * @param id уникальный идентификатор страны
     * @return страна, соответствующая уникальному идентификатору
     */
    Country getCountryById(Long id);

    /**
     * Поиск страны по коду
     *
     * @param citizenshipCode код страны
     * @return страна, соответствующая коду
     */
    Country getCountryByCitizenshipCode(String citizenshipCode);

    /**
     * Сохранение страны страну
     *
     * @param country страна, которую требуется сохранить
     */
    void saveCountry(Country country);
}
