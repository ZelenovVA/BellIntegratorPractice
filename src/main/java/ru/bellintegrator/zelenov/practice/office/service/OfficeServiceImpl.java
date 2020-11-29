package ru.bellintegrator.zelenov.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.office.dao.OfficeDao;
import ru.bellintegrator.zelenov.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.zelenov.practice.office.model.Office;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewOut;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeViewById;

import javax.validation.Valid;
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
    public List<OfficeListViewOut> getAllOffices(@Valid OfficeListViewIn filter) {
        return officeDao
                .getAllOffices(mapViewListInToEntity(filter))
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
        return mapEntityToViewById(officeDao.getOfficeById(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(@Valid OfficeUpdateView officeUpdateView) {
        officeDao.updateOffice(mapUpdateViewToEntity(officeUpdateView));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveOffice(@Valid OfficeSaveView officeSaveView) {
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
        office.setOrganization(organizationDao.getOrganizationById(officeListViewIn.getOrgId()));
        office.setName(officeListViewIn.getName());
        office.setPhone(officeListViewIn.getPhone());
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
        Office office = new Office();
        office.setId(officeUpdateView.getId());
        office.setName(officeUpdateView.getName());
        office.setAddress(officeUpdateView.getAddress());
        office.setPhone(officeUpdateView.getPhone());
        office.setIsActive(officeUpdateView.getIsActive());
        return office;
    }

    private Office mapSaveViewToEntity(OfficeSaveView officeSaveView) {
        Office office = new Office();
        office.setOrganization(organizationDao.getOrganizationById(officeSaveView.getOrgId()));
        office.setName(officeSaveView.getName());
        office.setAddress(officeSaveView.getAddress());
        office.setPhone(officeSaveView.getPhone());
        office.setIsActive(officeSaveView.getIsActive());
        return office;
    }
}
