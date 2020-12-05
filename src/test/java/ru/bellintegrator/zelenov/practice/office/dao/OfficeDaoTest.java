package ru.bellintegrator.zelenov.practice.office.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.office.model.Office;
import ru.bellintegrator.zelenov.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OfficeDaoTest {

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    OrganizationDao organizationDao;

    @Test
    void getAllOffices() {
        Office office = new Office();
        Organization organization = organizationDao.getOrganizationById(2L);
        office.setOrganization(organization);
        assertThat(this.officeDao.getAllOffices(office)).isNotNull();
        assertThat(this.officeDao.getAllOffices(office).size()).isGreaterThan(0);
    }

    @Test
    void getOfficeById() {
        assertThat(this.officeDao.getOfficeById(2L)).isNotNull();
        assertThat(this.officeDao.getOfficeById(2L).getName()).isEqualTo("Московский офис Huawei");
        assertThat(this.officeDao.getOfficeById(2L).getOrganization().getId()).isEqualTo(3L);
    }

    @Test
    void saveOffice() {
        Office office = new Office();
        Organization organization = organizationDao.getOrganizationById(1L);
        office.setOrganization(organization);
        this.officeDao.saveOffice(office);
    }

    @Test
    void updateOffice() {
        Office office=officeDao.getOfficeById(1L);
        office.setName("fksdjhaflkjshf");
        office.setAddress("toiywreiotyie");
        this.officeDao.updateOffice(office);
    }
}