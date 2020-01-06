package com.alchen.demo.spring.aop.dao;

import com.alchen.demo.spring.aop.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}
