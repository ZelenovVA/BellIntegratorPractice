package ru.bellintegrator.zelenov.practice.office.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.office.view.OfficeListViewIn;
import ru.bellintegrator.zelenov.practice.office.view.OfficeSaveView;
import ru.bellintegrator.zelenov.practice.office.view.OfficeUpdateView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OfficeControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllOffices() throws Exception {
        OfficeListViewIn officeListViewIn = new OfficeListViewIn();
        officeListViewIn.setOrgId(3L);
        String officeListViewInJSON = objectMapper.writeValueAsString(officeListViewIn);
        //Test with id
        //status 200
        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(officeListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray());

        //status 404
        officeListViewIn.setOrgId(8L);
        officeListViewInJSON = objectMapper.writeValueAsString(officeListViewIn);
        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(officeListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Organization with this id was not found"));

        //Test with id and name
        //status 200
        officeListViewIn.setOrgId(1L);
        officeListViewIn.setName("Google");
        officeListViewInJSON = objectMapper.writeValueAsString(officeListViewIn);
        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(officeListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].name").value("Московский офис Google"));
        //status 404
        officeListViewIn.setName("sdfsdgdf");
        officeListViewInJSON = objectMapper.writeValueAsString(officeListViewIn);
        this.mockMvc
                .perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(officeListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Offices with these parameters were not found"));
    }

    @Test
    void getOfficeById() throws Exception {
        //status 200
        this.mockMvc
                .perform(get("/api/office/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").isNotEmpty())
                .andExpect(jsonPath("$.data.name").value("Московский офис Huawei"));

        //status 404
        this.mockMvc
                .perform(get("/api/office/8"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Office with this id was not found"));
    }

    @Test
    void updateOffice() throws Exception {
        OfficeUpdateView officeUpdateView=new OfficeUpdateView();
        officeUpdateView.setId(2L);
        officeUpdateView.setName("fsgsdhdfjfhdj");
        officeUpdateView.setAddress("fsgsdsdfgsfgdfghdfjfhdj");
        String officeUpdateViewJSON=objectMapper.writeValueAsString(officeUpdateView);

        //status 200
        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(officeUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));

        //status 404
        officeUpdateView.setId(13L);
        officeUpdateViewJSON=objectMapper.writeValueAsString(officeUpdateView);
        this.mockMvc
                .perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(officeUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Office with this id was not found"));
    }

    @Test
    void saveOffice() throws Exception {
        OfficeSaveView officeSaveView=new OfficeSaveView();
        officeSaveView.setOrgId(1L);
        officeSaveView.setName("fkawueyfbgasdf");
        officeSaveView.setAddress("fkvfsgdfgdfgawueyfbgasdf");
        String officeSaveViewJSON=objectMapper.writeValueAsString(officeSaveView);

        //status 200
        this.mockMvc
                .perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(officeSaveViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));

        //status 404
        officeSaveView.setOrgId(6L);
        officeSaveViewJSON=objectMapper.writeValueAsString(officeSaveView);
        this.mockMvc
                .perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(officeSaveViewJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Organization with this id was not found"));
    }
}