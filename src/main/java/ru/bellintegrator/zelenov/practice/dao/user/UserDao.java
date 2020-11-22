package ru.bellintegrator.zelenov.practice.dao.user;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.zelenov.practice.model.user.User;

import java.util.List;

/**
 * DAO для работы с User{@link User}
 */
@Repository
public interface UserDao {
    /**
     * Получить список всех пользователей
     * @return список пользователей
     */
    List<User> getAllUsers(User user);

    /**
     * Получить пользователя по уникальному идентификатору
     * @param userId Уникальный идентификатор пользователя
     * @return
     */
    User getUserById(Long userId);

    /**
     * Сохранить организацию
     * @param user новый пользователь
     */
    void saveUser(User user);

    /**
     * Изменить данные организации
     * @param user Пользователь, данный которого нужно изменить
     */
    void updateUser(User user);

    /**
     * Удалить организацию по уникальному идентификатору
     * @param userId уникальный идентификатор пользователя
     */
    void removeUser(Long userId);
}

