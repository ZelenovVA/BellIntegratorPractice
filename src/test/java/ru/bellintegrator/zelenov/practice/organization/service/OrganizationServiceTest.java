package ru.bellintegrator.zelenov.practice.organization.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationUpdateView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OrganizationServiceTest {

    @Autowired
    OrganizationService organizationService;

    @Test
    void getOrganizations() {
        OrganizationListViewIn organizationListViewIn = new OrganizationListViewIn();
        organizationListViewIn.setName("Goog");
        assertThat(this.organizationService.getOrganizations(organizationListViewIn)).isNotNull();
        assertThat(this.organizationService.getOrganizations(organizationListViewIn).size()).isGreaterThan(0);
    }

    @Test
    void getOrganizationById() {
        assertThat(this.organizationService.getOrganizationById(1L)).isNotNull();
        assertThat(this.organizationService.getOrganizationById(1L).getName()).isEqualTo("Google");
    }

    @Test
    void updateOrganization() {
        OrganizationUpdateView organizationUpdateView = new OrganizationUpdateView();
        organizationUpdateView.setId(1L);
        organizationUpdateView.setName("sgafnksjafgn");
        organizationUpdateView.setFullName("aeukfytbgzcvhjsajk");
        organizationUpdateView.setInn("888888888888");
        organizationUpdateView.setKpp("101010101");
        organizationUpdateView.setAddress("gfnksjhfglkcsdvcsfjhg");
    }

    @Test
    void saveOrganization() {
        OrganizationSaveView organizationSaveView = new OrganizationSaveView();
        organizationSaveView.setInn("777777777777");
        organizationSaveView.setFullName("skljghsfhjglksdfjhgkljsd");
        organizationSaveView.setKpp("999999999");
        organizationSaveView.setAddress("gfnksjhfglksfjhg");
    }
}
