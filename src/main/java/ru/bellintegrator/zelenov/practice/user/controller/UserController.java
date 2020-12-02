package ru.bellintegrator.zelenov.practice.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.zelenov.practice.user.service.UserService;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewIn;
import ru.bellintegrator.zelenov.practice.user.view.UserListViewOut;
import ru.bellintegrator.zelenov.practice.user.view.UserSaveView;
import ru.bellintegrator.zelenov.practice.user.view.UserUpdateView;
import ru.bellintegrator.zelenov.practice.user.view.UserViewById;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с пользователем
 */
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получение списка пользователей по фильтру
     *
     * @param filter фильтр
     * @return список пользователей
     */
    @PostMapping("/list")
    @ApiOperation(value = "Get all users", httpMethod = "POST")
    public List<UserListViewOut> getAllUsers(@Valid @RequestBody UserListViewIn filter) {
        return userService.getAllUsers(filter);
    }

    /**
     * Получение пользователя по уникальному идентификатору
     *
     * @param id уникальный идентификатор пользователя
     * @return пользователь
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by id", httpMethod = "GET")
    public UserViewById getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * Изменение данных пользователя
     *
     * @param userUpdateView пользователь, данные коттрого требуется изменить
     */
    @PostMapping("/update")
    @ApiOperation(value = "Update user", httpMethod = "POST")
    public void updateUser(@Valid @RequestBody UserUpdateView userUpdateView) {
        userService.updateUser(userUpdateView);
    }

    /**
     * Соххранение нового пользователя
     *
     * @param userSaveView пользователь, которого требуется сохранить
     */
    @PostMapping("/save")
    @ApiOperation(value = "Save user", httpMethod = "POST")
    public void saveUser(@Valid @RequestBody UserSaveView userSaveView) {
        userService.saveUser(userSaveView);
    }
}
