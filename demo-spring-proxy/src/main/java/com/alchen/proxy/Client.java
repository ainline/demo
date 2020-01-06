package com.alchen.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        // 匿名内部类访问外部成员变量，要求是final
        final Producer producer = new Producer();

        /**
         * 基于接口的动态代理
         *  特点：字节码文件随用随修改，随用随加载
         *  作用：不修改源码基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理对象至少实现一个接口，如果没有则不能使用
         *  newProxyInstance方法参数：
         *      ClassLoader：
         *          用于加载代理对象字节码，和被代理对象使用相同的类加载器，固定写法
         *      Class[]：
         *          字节码数组，用于代理对象和被代理对象有相同方法，固定写法
         *      InvocationHandler:
         *          用于提供增强代码，一般写该接口的实现类，通常是匿名内部类，但不是必须的。
         */

        IProducer producerProxy = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法，都会经过该代理方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 和被代理对象方法有相同返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强方法
                        //1.获取方法执行的参数
                        Object rtn = null;
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            rtn = method.invoke(producer, money * 0.8f);
                        }
                        return rtn;
                    }
                });
        // 通过代理方法执行
        producerProxy.saleProduct(1000f);
    }
}
