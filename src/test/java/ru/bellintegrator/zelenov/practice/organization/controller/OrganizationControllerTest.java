package ru.bellintegrator.zelenov.practice.organization.controller;

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
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationListViewIn;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.zelenov.practice.organization.view.OrganizationUpdateView;

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
class OrganizationControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllOrganizations() throws Exception {
        OrganizationListViewIn organizationListViewIn = new OrganizationListViewIn();
        organizationListViewIn.setName("Goog");
        String orgViewInJASON = objectMapper.writeValueAsString(organizationListViewIn);
        //status 200
        this.mockMvc
                .perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(orgViewInJASON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data").isNotEmpty());
        //status 404
        organizationListViewIn.setName("ksjdhfgnkdf");
        orgViewInJASON = objectMapper.writeValueAsString(organizationListViewIn);
        this.mockMvc
                .perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(orgViewInJASON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty());
    }

    @Test
    void getOrganizationById() throws Exception {
        //status 200
        this.mockMvc
                .perform(get("/api/organization/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data.name").value("Яндекс"));
        //status 404
        this.mockMvc
                .perform(get("/api/organization/5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty());
    }

    @Test
    void updateOrganization() throws Exception {
        OrganizationUpdateView organizationUpdateView = new OrganizationUpdateView();
        organizationUpdateView.setId(3L);
        organizationUpdateView.setName("vsfgsdfgd");
        organizationUpdateView.setFullName("dfsasdfasdfasdfasdfgsfdgsdfg");
        organizationUpdateView.setInn("123456654321");
        organizationUpdateView.setKpp("987654321");
        organizationUpdateView.setAddress("fasdfrshdghdggsats");
        String organizationUpdateViewJSON = objectMapper.writeValueAsString(organizationUpdateView);
        //status 200
        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(organizationUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));

        //status 404
        organizationUpdateView.setId(7L);
        organizationUpdateViewJSON = objectMapper.writeValueAsString(organizationUpdateView);
        this.mockMvc
                .perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(organizationUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty());
    }

    @Test
    void saveOrganization() throws Exception {
        OrganizationSaveView organizationSaveView = new OrganizationSaveView();
        organizationSaveView.setName("vsfgdsadfssdfgd");
        organizationSaveView.setFullName("dfsasdfasdfasdfasdfgsfdafsdgdfgdfgsdfg");
        organizationSaveView.setInn("123456789987");
        organizationSaveView.setKpp("987654456");
        organizationSaveView.setAddress("fasdffsdfsdfrshdghdggsats");
        String organizationSaveViewJSON = objectMapper.writeValueAsString(organizationSaveView);
        //status 200
        this.mockMvc
                .perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(organizationSaveViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));
    }
}