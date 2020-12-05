package ru.bellintegrator.zelenov.practice.organization.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.organization.model.Organization;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OrganizationDaoTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Test
    void getAllOrganizations() {
        Organization organization = new Organization();
        organization.setName("Goog");
        assertThat(this.organizationDao.getAllOrganizations(organization)).isNotNull();
        assertThat(this.organizationDao.getAllOrganizations(organization).size()).isGreaterThan(0);
    }

    @Test
    void getOrganizationById() {
        assertThat(this.organizationDao.getOrganizationById(2L)).isNotNull();
        assertThat(this.organizationDao.getOrganizationById(2L).getKpp()).isEqualTo("444444444");
    }

    @Test
    void saveOrganization() {
        Organization organization=new Organization();
        organization.setName("Organization");
        organization.setInn("777777777777");
        organization.setFullName("skljghsfhjglksdfjhgkljsd");
        organization.setKpp("999999999");
        organization.setAddress("gfnksjhfglksfjhg");
        this.organizationDao.saveOrganization(organization);
    }

    @Test
    void updateOrganization() {
        Organization organization=organizationDao.getOrganizationById(1L);
        organization.setName("Organization2");
        organization.setInn("888888888888");
        organization.setFullName("skljghasdadsfhjglksdfjhgkljsd");
        organization.setKpp("101010101");
        organization.setAddress("gfnksjhfglkcsdvcsfjhg");
        this.organizationDao.updateOrganization(organization);
    }
}