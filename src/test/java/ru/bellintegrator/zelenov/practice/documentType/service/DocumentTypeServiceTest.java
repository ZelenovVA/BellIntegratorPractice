package ru.bellintegrator.zelenov.practice.documentType.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.documentType.view.DocumentTypeView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class DocumentTypeServiceTest {

    @Autowired
    DocumentTypeService documentTypeService;

    @Test
    void getAllDocTypes() {
        assertThat(this.documentTypeService.getAllDocTypes()).isNotNull();
        assertThat(this.documentTypeService.getAllDocTypes().size()).isGreaterThan(0);
        assertThat(this.documentTypeService.getAllDocTypes().get(0) instanceof DocumentTypeView).isTrue();
    }
}