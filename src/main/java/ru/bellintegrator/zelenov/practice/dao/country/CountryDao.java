package ru.bellintegrator.zelenov.practice.dao.country;

import ru.bellintegrator.zelenov.practice.model.country.Country;

import java.util.List;

/**
 * DAO для справичника стран, гражданином которых является пользователь
 */
public interface CountryDao {
    /**
     * Получение списка стран
     * @return список стран
     */
    List<Country> getAllCountries();

    /**
     * Получение страны по уникальному идентификатору
     * @param id уникальный идентификатор страны
     * @return страна, соответствующая уникальному идентификатору
     */
    Country getCountryById(Long id);

    /**
     * Сохранение страны страну
     * @param country страна, которую требуется сохранить
     */
    void saveCountry(Country country);
}
