package com.alchen.demo.spring.anno.service.impl;


import com.alchen.demo.spring.anno.dao.IUserDao;
import com.alchen.demo.spring.anno.entity.User;
import com.alchen.demo.spring.anno.service.IUserService;
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
