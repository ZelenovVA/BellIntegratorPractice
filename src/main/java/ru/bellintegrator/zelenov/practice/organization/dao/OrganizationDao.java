package ru.bellintegrator.zelenov.practice.organization.dao;

import ru.bellintegrator.zelenov.practice.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization{@link Organization}
 */
public interface OrganizationDao {
    /**
     * Получить список всех организаций
     *
     * @return список организаций
     */
    List<Organization> getAllOrganizations(Organization organization);

    /**
     * Получить организацию по уникальному идентификатору
     *
     * @param organizationId уникальный идентификатор организации
     * @return организацию по уникальному идентификатору
     */
    Organization getOrganizationById(Long organizationId);

    /**
     * Сохранить организацию
     *
     * @param organization организация, которую требуется сохранить
     */
    void saveOrganization(Organization organization);

    /**
     * Изменить данные организации
     *
     * @param organization организация, которую требуется изменить
     */
    void updateOrganization(Organization organization);

    /**
     * Удалить организацию по уникальному идентификатору
     *
     * @param id уникальный идентификатор организации
     */
    void removeOrganization(Long id);
}
