package ru.bellintegrator.zelenov.practice.document.dao;

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
class DocumentDaoTest {

    @Autowired
    private DocumentDao documentDao;

    @Test
    void getAllDocuments() {
        assertThat(this.documentDao.getAllDocuments()).isNotNull();
        assertThat(this.documentDao.getAllDocuments().size()).isGreaterThan(0);
    }

    @Test
    void getDocumentById() {
        assertThat(this.documentDao.getDocumentById(1L)).isNotNull();
        assertThat(this.documentDao.getDocumentById(1L).getUser().getId()).isEqualTo(1L);
        assertThat(this.documentDao.getDocumentById(1L).getDocNumber()).isEqualTo("1221123456");
    }
}