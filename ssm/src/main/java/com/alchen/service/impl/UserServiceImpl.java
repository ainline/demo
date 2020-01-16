package com.alchen.service.impl;

import com.alchen.dao.IUserDao;
import com.alchen.domain.User;
import com.alchen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User findUserById() {
        return userDao.findUserById();
    }
}
