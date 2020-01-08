package com.alchen.spring.xml.service.impl;

import com.alchen.spring.xml.dao.IUserDao;
import com.alchen.spring.xml.entity.User;
import com.alchen.spring.xml.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public User findOneUser(Integer id) {
        return userDao.findOneUser(id);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUserById(Integer id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
