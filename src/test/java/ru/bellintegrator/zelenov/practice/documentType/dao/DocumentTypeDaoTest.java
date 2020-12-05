package ru.bellintegrator.zelenov.practice.documentType.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class DocumentTypeDaoTest {

    @Autowired
    private DocumentTypeDao documentTypeDao;

    @Test
    void getAllDocTypes() {
        assertThat(this.documentTypeDao.getAllDocTypes()).isNotNull();
        assertThat(this.documentTypeDao.getAllDocTypes().size()).isGreaterThan(0);
        System.out.println(this.documentTypeDao.getDocTypeById(2L));
    }

    @Test
    void getDocTypeById() {
        assertThat(this.documentTypeDao.getDocTypeById(1L)).isNotNull();
        assertThat(this.documentTypeDao.getDocTypeById(1L).getDocName()).isEqualTo("Свидетельство о рождении");
    }

    @Test
    void getDocTypeByDocCode() {
        assertThat(this.documentTypeDao.getDocTypeByDocCode("07")).isNotNull();
        assertThat(this.documentTypeDao.getDocTypeByDocCode("07").getDocName()).isEqualTo("Военный билет");
    }
}