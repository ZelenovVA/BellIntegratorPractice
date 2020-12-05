package ru.bellintegrator.zelenov.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.exception.DataNotFoundException;
import ru.bellintegrator.zelenov.practice.office.dao.OfficeDao;
import ru.bellintegrator.zelenov.practice.office.model.Office;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewOut;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeViewById;
import ru.bellintegrator.zelenov.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeListViewOut> getAllOffices(OfficeListViewIn filter) {
        List<Office> offices = officeDao.getAllOffices(mapViewListInToEntity(filter));
        if (offices.isEmpty()) {
            throw new DataNotFoundException("Offices with these parameters were not found");
        }
        return offices
                .stream()
                .map(mapEntityToViewListIn())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeViewById getOfficeById(Long id) {
        Office office = officeDao.getOfficeById(id);
        if (office == null) {
            throw new DataNotFoundException("Office with this id was not found");
        }
        return mapEntityToViewById(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(OfficeUpdateView officeUpdateView) {
        officeDao.updateOffice(mapUpdateViewToEntity(officeUpdateView));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(OfficeSaveView officeSaveView) {
        officeDao.saveOffice(mapSaveViewToEntity(officeSaveView));
    }

    private Function<Office, OfficeListViewOut> mapEntityToViewListIn() {
        return office -> {
            OfficeListViewOut officeListViewOut = new OfficeListViewOut();
            officeListViewOut.setId(office.getId());
            officeListViewOut.setName(office.getName());
            officeListViewOut.setIsActive(office.getIsActive());
            return officeListViewOut;
        };
    }

    private Office mapViewListInToEntity(OfficeListViewIn officeListViewIn) {
        Office office = new Office();
        Organization organization = organizationDao.getOrganizationById(officeListViewIn.getOrgId());
        if (organization == null) {
            throw new DataNotFoundException("Organization with this id was not found");
        }
        office.setOrganization(organization);
        if (officeListViewIn.getName() != null) {
            office.setName(officeListViewIn.getName());
        }
        if (officeListViewIn.getPhone() != null) {
            office.setPhone(officeListViewIn.getPhone());
        }
        office.setIsActive(officeListViewIn.getIsActive());
        return office;
    }

    private OfficeViewById mapEntityToViewById(Office office) {
        OfficeViewById officeViewById = new OfficeViewById();
        officeViewById.setId(office.getId());
        officeViewById.setName(office.getName());
        officeViewById.setAddress(office.getAddress());
        officeViewById.setPhone(office.getPhone());
        officeViewById.setIsActive(office.getIsActive());
        return officeViewById;
    }

    private Office mapUpdateViewToEntity(OfficeUpdateView officeUpdateView) {
        Office office = officeDao.getOfficeById(officeUpdateView.getId());
        if (office == null) {
            throw new DataNotFoundException("Office with this id was not found");
        }
        office.setName(officeUpdateView.getName());
        office.setAddress(officeUpdateView.getAddress());
        if (officeUpdateView.getPhone() != null) {
            office.setPhone(officeUpdateView.getPhone());
        }
        office.setIsActive(officeUpdateView.getIsActive());
        return office;
    }

    private Office mapSaveViewToEntity(OfficeSaveView officeSaveView) {
        Office office = new Office();
        Organization organization = organizationDao.getOrganizationById(officeSaveView.getOrgId());
        if (organization == null) {
            throw new DataNotFoundException("Organization with this id was not found");
        }
        office.setOrganization(organization);
        if (officeSaveView.getName() != null) {
            office.setName(officeSaveView.getName());
        }
        if (officeSaveView.getAddress() != null) {
            office.setAddress(officeSaveView.getAddress());
        }
        if (officeSaveView.getPhone() != null) {
            office.setPhone(officeSaveView.getPhone());
        }
        if (officeSaveView.getIsActive() != null) {
            office.setIsActive(officeSaveView.getIsActive());
        }
        return office;
    }
}
