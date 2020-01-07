package com.alchen.test;

import com.alchen.demo.spring.aopxml.service.IAccountService;
import com.alchen.demo.spring.aopxml.service.impl.AccountServiceImpl;
import com.alchen.demo.spring.aopxml.utils.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AopTest {

    /**
     * 模拟AOP，手动通过动态代理实现方法增强
     */
    @Test
    public void testProxy() {
        IAccountService accountService = new AccountServiceImpl();
        Logger logger = new Logger();

        IAccountService asp = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        logger.pringLog();
                        rtValue = method.invoke(accountService,args);
                        logger.pringLog();
                        return rtValue;
                    }
                });
        asp.saveAccount();
    }

    @Test
    public void testAop(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
//        accountService.saveAccount();
//        accountService.deleteAccount();
        accountService.updateAccount(1);
    }
}
