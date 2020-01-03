package com.alchen.demo.spring.anno.dao;

import com.alchen.demo.spring.anno.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}
