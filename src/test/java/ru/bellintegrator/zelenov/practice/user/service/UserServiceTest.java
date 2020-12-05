package ru.bellintegrator.zelenov.practice.user.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewIn;
import ru.bellintegrator.zelenov.practice.user.view.UserSaveView;
import ru.bellintegrator.zelenov.practice.user.view.UserUpdateView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void getAllUsers() {
        UserListViewIn userListViewIn=new UserListViewIn();
        userListViewIn.setOfficeId(1L);
        userListViewIn.setCitizenshipCode("643");
        assertThat(this.userService.getAllUsers(userListViewIn)).isNotNull();
        assertThat(this.userService.getAllUsers(userListViewIn).size()).isGreaterThan(0);
    }

    @Test
    void getUserById() {
        assertThat(this.userService.getUserById(2L)).isNotNull();
        assertThat(this.userService.getUserById(2L).getFirstName()).isEqualTo("Оксана");
    }

    @Test
    void updateUser() {
        UserUpdateView userUpdateView=new UserUpdateView();
        userUpdateView.setId(2L);
        userUpdateView.setFirstName("ksjhdfgbkgh");
        userUpdateView.setPosition("ksjhdfgvsbgdghdghbkgh");
        this.userService.updateUser(userUpdateView);
    }

    @Test
    void saveUser() {
        UserSaveView userSaveView=new UserSaveView();
        userSaveView.setOfficeId(3L);
        userSaveView.setFirstName("iufriwe");
        userSaveView.setPosition("eqweqweqwewqe");
        this.userService.saveUser(userSaveView);
    }
}