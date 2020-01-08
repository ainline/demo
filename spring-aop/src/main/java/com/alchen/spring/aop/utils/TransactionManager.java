package com.alchen.spring.aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理相关工具类，开启，提交，回滚，释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    //设置切入点表达式方法
    @Pointcut("execution(* com.alchen.demo.spring.aop.service.*.*(..))")
    public void pt(){}

    /**
     * 环绕通知-事务处理
     */
    @Around("pt()")
    public void aroundTransaction(ProceedingJoinPoint pjp) {
        Object rt = null;
        Object[] args = pjp.getArgs();
        try {
            begin();
            rt = pjp.proceed(args);
            commit();
        } catch (Throwable throwable) {
            rollback();
            throwable.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 开启事务
     */
    public void begin() {
        try {
            System.out.println("事务开启...");
            connectionUtil.getTreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            System.out.println("事务提交...");
            connectionUtil.getTreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            System.out.println("事务回滚...");
            connectionUtil.getTreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void close() {
        try {
            System.out.println("连接关闭，线程解绑...");
            connectionUtil.getTreadConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
