package ru.bellintegrator.zelenov.practice.office.dao;

import ru.bellintegrator.zelenov.practice.office.model.Office;

import java.util.List;

/**
 * DAO для работы с Office{@link Office}
 */
public interface OfficeDao {
    /**
     * Получение списка всех офисов
     *
     * @return список офисов
     */
    List<Office> getAllOffices(Office office);

    /**
     * Получение офиса по уникальному идентификатору
     *
     * @param officeId уникальный
     * @return офис по уникальному идентификатору
     */
    Office getOfficeById(Long officeId);

    /**
     * Сохранение офис
     *
     * @param office
     */
    void saveOffice(Office office);

    /**
     * Изменение офиса
     *
     * @param office
     */
    void updateOffice(Office office);

    /**
     * Удаление офис
     *
     * @param officeId Уникальный идентификатор офиса
     */
    void removeOffice(Long officeId);
}
