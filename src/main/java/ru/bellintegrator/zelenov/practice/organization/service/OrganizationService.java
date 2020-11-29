package ru.bellintegrator.zelenov.practice.organization.service;

import ru.bellintegrator.zelenov.practice.organization.model.Organization;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewOut;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationUpdateView;

import java.util.List;

/**
 * Сервисный слой для работы с организацией
 */
public interface OrganizationService {

    /**
     * Получение списка организаций
     *
     * @param filter фильтр поиска
     * @return список организаций
     */
    List<OrganizationListViewOut> getOrganizations(OrganizationListViewIn filter);

    /**
     * Получение организации по уникальному идентификатору
     *
     * @param id уникальный идентификатор организации
     * @return организация
     */
    Organization getOrganizationById(Long id);

    /**
     * Изменение данных организации
     *
     * @param organizationUpdateView организация, данные которой нужно изменить
     */
    void updateOrganization(OrganizationUpdateView organizationUpdateView);

    /**
     * Сохранение новой организации
     *
     * @param organizationSaveView организация, которую требуется сохранить
     */
    void saveOrganization(OrganizationSaveView organizationSaveView);
}
