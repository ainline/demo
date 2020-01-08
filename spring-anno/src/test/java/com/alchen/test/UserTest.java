package com.alchen.test;

import com.alchen.spring.aop.config.SpringConfiguration;
import com.alchen.spring.aop.entity.User;
import com.alchen.spring.aop.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        User user = userService.findOneUser(1);
        System.out.println(user);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setAge(11);
        user.setCard("00003");
        user.setName("kes");
        userService.saveUser(user);
    }

    @Test
    public void testDelete() {
        userService.deleteUserById(2);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4);
        user.setAge(11);
        user.setCard("03333");
        user.setName("ess");
        userService.updateUser(user);
    }
}
