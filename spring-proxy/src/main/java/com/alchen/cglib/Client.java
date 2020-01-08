package com.alchen.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        // 匿名内部类访问外部成员变量，要求是final
        final Producer producer = new Producer();

        /**
         * 基于子类的动态代理
         *  特点：字节码文件随用随修改，随用随加载
         *  作用：不修改源码基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理：
         *      涉及的类：Enhancer
         *      提供者：cglib
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *  创建代理对象的要求：
         *      被代理对象不能是最终类
         *  newProxyInstance方法参数：
         *      Class：字节码
         *          用于指定被代理对象的字节码。
         *      Callback: 用于提供增强的代码
         *          用于提供增强代码，一般写该接口的实现类，通常是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写。
         *          一般写的都是该接口的子接口实现类：MethodInterceptor
         */

        Producer producerCglib = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return 和被代理对象执行的方法返回值一样
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object obj = null;
                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    obj = method.invoke(producer, money * 0.8f);
                }
                return obj;
            }
        });
        // 通过代理方法执行
        producerCglib.saleProduct(1000f);
    }
}
