package com.alchen.dao;

import com.alchen.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> findAllUser();

    User findOneUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}
