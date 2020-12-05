package ru.bellintegrator.zelenov.practice.user.controller;

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
import ru.bellintegrator.zelenov.practice.user.view.UserListViewIn;
import ru.bellintegrator.zelenov.practice.user.view.UserSaveView;
import ru.bellintegrator.zelenov.practice.user.view.UserUpdateView;

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
class UserControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllUsers() throws Exception {
        UserListViewIn userListViewIn = new UserListViewIn();
        userListViewIn.setOfficeId(1L);
        String userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);

        //Test with id
        //status 200
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].firstName").value("Оксана"));
        //status 404
        userListViewIn.setOfficeId(12L);
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Office with this id was not found"));

        //Test with id and name
        //status 200
        userListViewIn.setOfficeId(2L);
        userListViewIn.setFirstName("Сергей");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].firstName").value("Сергей"));
        //status 404
        userListViewIn.setFirstName("dafgdgjfhj");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Users with these parameters were not found"));
        //Test with id and position
        //status 200
        userListViewIn.setOfficeId(3L);
        userListViewIn.setFirstName(null);
        userListViewIn.setPosition("Разработчик");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].position").value("Разработчик ПО"));
        //status 404
        userListViewIn.setPosition("dafgsdasdasddgjfhj");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Users with these parameters were not found"));
        //Test with id and docCode
        //status 200
        userListViewIn.setPosition(null);
        userListViewIn.setOfficeId(2L);
        userListViewIn.setDocCode("07");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].firstName").value("Сергей"));
        //status 404
        userListViewIn.setDocCode("0778");
        userListViewInJSON = objectMapper.writeValueAsString(userListViewIn);
        this.mockMvc
                .perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(userListViewInJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Document type with this document code was not found"));
    }

    @Test
    void getUserById() throws Exception {

        //Status 200
        this.mockMvc
                .perform(get("/api/user/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andExpect(jsonPath("$.data.firstName").value("Оксана"));
        //status 404
        this.mockMvc
                .perform(get("/api/user/22"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("User with this id was not found"));
    }

    @Test
    void updateUser() throws Exception {
        UserUpdateView userUpdateView = new UserUpdateView();
        userUpdateView.setId(3L);
        userUpdateView.setFirstName("hfaisgfbksjf");
        userUpdateView.setPosition("hriwftybksdg");
        String userUpdateViewJSON = objectMapper.writeValueAsString(userUpdateView);
        //status 200
        this.mockMvc
                .perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(userUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));

        //status 404
        userUpdateView.setId(33L);
        userUpdateViewJSON = objectMapper.writeValueAsString(userUpdateView);
        this.mockMvc
                .perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(userUpdateViewJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("User with this id was not found"));
    }

    @Test
    void saveUser() throws Exception {
        UserSaveView userSaveView=new UserSaveView();
        userSaveView.setOfficeId(2L);
        userSaveView.setFirstName("rywyieubtksdgh");
        userSaveView.setPosition("kfsdjag");
        String userSaveViewJSON=objectMapper.writeValueAsString(userSaveView);
        //status 200
        this.mockMvc
                .perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(userSaveViewJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").isNotEmpty())
                .andExpect(jsonPath("$.result").value("success"));

        //status 404
        userSaveView.setOfficeId(33L);
        userSaveViewJSON = objectMapper.writeValueAsString(userSaveView);
        this.mockMvc
                .perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(userSaveViewJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").value("Office with this id was not found"));
    }
}