package com.alchen.demo.spring.anno.service;


import com.alchen.demo.spring.anno.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);
}
