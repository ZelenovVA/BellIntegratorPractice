package ru.bellintegrator.zelenov.practice.user.service;

import ru.bellintegrator.zelenov.practice.user.view.UserListViewIn;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewOut;
import ru.bellintegrator.zelenov.practice.user.view.UserSaveView;
import ru.bellintegrator.zelenov.practice.user.view.UserUpdateView;
import ru.bellintegrator.zelenov.practice.user.view.UserViewById;

import java.util.List;

/**
 * Сервисный слой для работы с пользователем
 */
public interface UserService {

    /**
     * Получение списка пользователей по входящему фильтру
     *
     * @param filter фильтр
     * @return список пользователей
     */
    List<UserListViewOut> getAllUsers(UserListViewIn filter);

    /**
     * Получение пользователья по уникальному идентификатору
     *
     * @param id уникальный идентификатор пользователя
     * @return пользователь, соответствующий уникальному идентификатору
     */
    UserViewById getUserById(Long id);

    /**
     * Изменение данных пользователя
     *
     * @param userUpdateView пользователь, данные которого требуется изменить
     */
    void updateUser(UserUpdateView userUpdateView);

    /**
     * Сохранение нового пользователя
     *
     * @param userSaveView пользователь, которого требуется сохранить
     */
    void saveUser(UserSaveView userSaveView);
}
