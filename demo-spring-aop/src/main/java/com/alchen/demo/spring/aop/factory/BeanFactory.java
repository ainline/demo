package com.alchen.demo.spring.aop.factory;

import com.alchen.demo.spring.aop.service.IAccountService;
import com.alchen.demo.spring.aop.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现事务
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        try {
                            txManager.begin();
                            obj = method.invoke(accountService, args);
                            txManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            txManager.rollback();
                        } finally {
                            txManager.close();
                        }
                        return obj;
                    }

                });
    }
}
