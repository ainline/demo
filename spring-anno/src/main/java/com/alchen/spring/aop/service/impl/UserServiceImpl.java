package com.alchen.spring.aop.service.impl;


import com.alchen.spring.aop.dao.IUserDao;
import com.alchen.spring.aop.entity.User;
import com.alchen.spring.aop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

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
