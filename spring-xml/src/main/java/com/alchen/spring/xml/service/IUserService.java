package com.alchen.spring.xml.service;

import com.alchen.spring.xml.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);
}
