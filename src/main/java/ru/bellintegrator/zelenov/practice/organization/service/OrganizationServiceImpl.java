package ru.bellintegrator.zelenov.practice.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.exception.DataNotFoundException;
import ru.bellintegrator.zelenov.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewOut;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationUpdateView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListViewOut> getOrganizations(OrganizationListViewIn filter) {
        List<Organization> organizations = organizationDao.getAllOrganizations(mapViewListInToEntity(filter));
        if (organizations.isEmpty()) {
            throw new DataNotFoundException("Организации с данными параметрами отсутствуют");
        }
        return organizations
                .stream()
                .map(mapEntityToViewListOut())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Organization getOrganizationById(Long id) {
        Organization organization = organizationDao.getOrganizationById(id);
        if (organization == null) {
            throw new DataNotFoundException("Организация с данным id не найдена");
        }
        return organizationDao.getOrganizationById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrganization(OrganizationUpdateView organizationUpdateView) {
        organizationDao.updateOrganization(mapOrganizationUpdateViewToEntity(organizationUpdateView));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOrganization(OrganizationSaveView organizationSaveView) {
        organizationDao.saveOrganization(mapOrganizationSaveViewToEntity(organizationSaveView));
    }

    private Function<Organization, OrganizationListViewOut> mapEntityToViewListOut() {
        return organization -> {
            OrganizationListViewOut organizationListViewOut = new OrganizationListViewOut();
            organizationListViewOut.setId(organization.getId());
            organizationListViewOut.setName(organization.getName());
            organizationListViewOut.setIsActive(organization.getIsActive());
            return organizationListViewOut;
        };
    }

    private Organization mapViewListInToEntity(OrganizationListViewIn organizationListViewIn) {
        Organization organization = new Organization();
        organization.setName(organizationListViewIn.getName());
        if (organizationListViewIn.getInn() != null) {
            organization.setInn(organizationListViewIn.getInn());
        }
        if (organizationListViewIn != null) {
            organization.setIsActive(organizationListViewIn.getIsActive());
        }
        return organization;
    }

    private Organization mapOrganizationUpdateViewToEntity(OrganizationUpdateView organizationUpdateView) {
        Organization organization = organizationDao.getOrganizationById(organizationUpdateView.getId());
        if (organization == null) {
            throw new DataNotFoundException("Организация с данным id не найдена");
        }
        organization.setName(organizationUpdateView.getName());
        organization.setFullName(organizationUpdateView.getFullName());
        organization.setInn(organizationUpdateView.getInn());
        organization.setKpp(organizationUpdateView.getKpp());
        organization.setAddress(organizationUpdateView.getAddress());
        if (organizationUpdateView.getPhone() != null) {
            organization.setPhone(organizationUpdateView.getPhone());
        }
        ;
        organization.setIsActive(organizationUpdateView.getIsActive());
        return organization;
    }

    private Organization mapOrganizationSaveViewToEntity(OrganizationSaveView organizationSaveView) {
        Organization organization = new Organization();
        organization.setName(organizationSaveView.getName());
        organization.setFullName(organizationSaveView.getFullName());
        organization.setInn(organizationSaveView.getInn());
        organization.setKpp(organizationSaveView.getKpp());
        organization.setAddress(organizationSaveView.getAddress());
        if (organizationSaveView.getPhone() != null) {
            organization.setPhone(organizationSaveView.getPhone());
        }
        organization.setIsActive(organizationSaveView.getIsActive());
        return organization;
    }
}
