package com.alchen.service;

import com.alchen.controller.UserController;
import com.alchen.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);
}
