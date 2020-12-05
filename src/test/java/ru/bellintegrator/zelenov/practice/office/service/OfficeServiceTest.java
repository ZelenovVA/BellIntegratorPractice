package ru.bellintegrator.zelenov.practice.office.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OfficeServiceTest {

    @Autowired
    OfficeService officeService;

    @Test
    void getAllOffices() {
        OfficeListViewIn officeListViewIn = new OfficeListViewIn();
        officeListViewIn.setOrgId(2L);
        assertThat(this.officeService.getAllOffices(officeListViewIn)).isNotNull();
        assertThat(this.officeService.getAllOffices(officeListViewIn).size()).isGreaterThan(0);
    }

    @Test
    void getOfficeById() {
        assertThat(this.officeService.getOfficeById(3L)).isNotNull();
        assertThat(this.officeService.getOfficeById(3L).getName()).isEqualTo("Санкт-Петербургский офис Яндекс");
    }

    @Test
    void updateOffice() {
        OfficeUpdateView officeUpdateView = new OfficeUpdateView();
        officeUpdateView.setId(1L);
        officeUpdateView.setName("gsfhdfgjd");
        officeUpdateView.setAddress("gsfhdfgvfdsgsdhdfgjdfjd");
        this.officeService.updateOffice(officeUpdateView);
    }

    @Test
    void saveOffice() {
        OfficeSaveView officeSaveView = new OfficeSaveView();
        officeSaveView.setOrgId(2L);
        officeSaveView.setName("gfdhdghhfghjfg");
        officeSaveView.setAddress("erwerteryrutyui");
        this.officeService.saveOffice(officeSaveView);
    }
}