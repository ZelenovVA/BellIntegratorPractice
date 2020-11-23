package ru.bellintegrator.zelenov.practice.service.organization;

import org.springframework.stereotype.Service;
import ru.bellintegrator.zelenov.practice.model.organization.Organization;
import ru.bellintegrator.zelenov.practice.view.organization.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.view.organization.OrganizationListViewOut;
import ru.bellintegrator.zelenov.practice.view.organization.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.view.organization.OrganizationUpdateView;

import java.util.List;

/**
 * Сервисный слой для работы с организацией
 */
public interface OrganizationService {

    /**
     * Получение списка организаций
     * @param filter фильтр поиска
     * @return список организаций
     */
    List<OrganizationListViewOut> getOrganizations(OrganizationListViewIn filter);

    /**
     * Получение организации по уникальному идентификатору
     * @param id уникальный идентификатор организации
     * @return организация
     */
    Organization getOrganizationById(Long id);

    /**
     * Изменение данных организации
     * @param organizationUpdateView организация, данные которой нужно изменить
     */
    void updateOrganization(OrganizationUpdateView organizationUpdateView);

    /**
     * Сохранение новой организации
     * @param organizationSaveView организация, которую требуется сохранить
     */
    void saveOrganization(OrganizationSaveView organizationSaveView);
}
