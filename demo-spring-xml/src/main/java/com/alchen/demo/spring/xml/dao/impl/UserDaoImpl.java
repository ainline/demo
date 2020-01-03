package com.alchen.demo.spring.xml.dao.impl;

import com.alchen.demo.spring.xml.dao.IUserDao;
import com.alchen.demo.spring.xml.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    public List<User> findAllUser() {
        try {
            return qr.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findOneUser(Integer id) {
        try {
            return qr.query("select * from user where id = ?", id, new BeanHandler<User>(User.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(User user) {
        try {
            qr.update("insert into user(name,age,card)values(?,?,?)", user.getName(), user.getAge(), user.getCard());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(Integer id) {
        try {
            qr.update("delete from user where id=?", id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try {
            qr.update("update user set name=?, age=?, card=? where id=?", user.getName(), user.getAge(), user.getCard(), user.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
