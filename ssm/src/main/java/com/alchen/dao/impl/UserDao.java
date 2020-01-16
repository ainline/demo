package com.alchen.dao.impl;

import com.alchen.dao.IUserDao;
import com.alchen.domain.User;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao implements IUserDao {

    @Override
    public User findUserById() {
        User user = new User();
        user.setName("chen");
        user.setAge(12);
        user.setCard("0001");
        return user;
    }
}
