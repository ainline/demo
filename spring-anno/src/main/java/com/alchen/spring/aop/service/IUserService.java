package com.alchen.spring.aop.service;


import com.alchen.spring.aop.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);
}
