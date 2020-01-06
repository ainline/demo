package com.alchen.test;

import com.alchen.demo.spring.aop.config.SpringConfiguration;
import com.alchen.demo.spring.aop.entity.User;
import com.alchen.demo.spring.aop.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        User user = userService.findOneUser(1);
        System.out.println(user);
    }

    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        User user = new User();
        user.setAge(11);
        user.setCard("00003");
        user.setName("kes");
        userService.saveUser(user);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        userService.deleteUserById(2);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        User user = new User();
        user.setId(4);
        user.setAge(11);
        user.setCard("03333");
        user.setName("ess");
        userService.updateUser(user);
    }
}
