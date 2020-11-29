package ru.bellintegrator.zelenov.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;
import ru.bellintegrator.zelenov.practice.organization.service.OrganizationService;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewOut;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationUpdateView;

import java.util.List;

/**
 * Контроллер для работы с организацией
 */
@RestController
@RequestMapping(value = "/api/organization/", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получение списка организаций по фильтру
     *
     * @param organizationListViewIn фильтр
     * @return список организаций
     */
    @PostMapping("list")
    public List<OrganizationListViewOut> getAllOrganizations(@RequestBody OrganizationListViewIn organizationListViewIn) {
        return organizationService.getOrganizations(organizationListViewIn);
    }

    /**
     * Получение организации по уникальному идентификатору
     *
     * @param id уникальный идентификатор организации
     * @return организация
     */
    @GetMapping("{id}")
    public Organization getOrganizationById(@PathVariable("id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    /**
     * Изменение организации
     *
     * @param organizationUpdateView организация, которую нужно изменить
     * @return результат операции
     */
    @PostMapping("update")
    public void updateOrganization(@RequestBody OrganizationUpdateView organizationUpdateView) {
        organizationService.updateOrganization(organizationUpdateView);
    }

    /**
     * Сохранение новой организации
     *
     * @param organizationSaveView организация, которую требуется сохранить
     * @return результат операции
     */
    @PostMapping("save")
    public void saveOrganization(@RequestBody OrganizationSaveView organizationSaveView) {
        organizationService.saveOrganization(organizationSaveView);
    }
}
