package ru.bellintegrator.zelenov.practice.user.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.zelenov.practice.office.dao.OfficeDao;
import ru.bellintegrator.zelenov.practice.office.model.Office;
import ru.bellintegrator.zelenov.practice.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Autowired
    OfficeDao officeDao;

    @Test
    void getAllUsers() {
        User user = new User();
        Office office = officeDao.getOfficeById(2L);
        user.setOffice(office);
        user.setFirstName("Сергей");
        assertThat(this.userDao.getAllUsers(user)).isNotNull();
        assertThat(this.userDao.getAllUsers(user).size()).isGreaterThan(0);
    }

    @Test
    void getUserById() {
        assertThat(this.userDao.getUserById(3L)).isNotNull();
        assertThat(this.userDao.getUserById(3L).getFirstName()).isEqualTo("Сергей");
    }

    @Test
    void saveUser() {
        User user = new User();
        Office office = officeDao.getOfficeById(2L);
        user.setOffice(office);
        user.setFirstName("Borat");
        user.setSecondName("Sagdiev");
        user.setPosition("Journalist");
    }

    @Test
    void updateUser() {
        User user = userDao.getUserById(3L);
        Office office = officeDao.getOfficeById(2L);
        user.setOffice(office);
        user.setFirstName("Borat");
        user.setSecondName("Sagdiev");
        user.setPosition("Journalist");
    }
}