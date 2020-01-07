package com.alchen.demo.spring.aopxml.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志工具类，公共代码
 */
public class Logger {

    /**
     * 环绕通知
     * 问题：配置环绕通知后，切入点方法没有执行，通知方法执行了
     * 分析：与动态代理中环绕通知代码比较，动态代理中环绕通知有明确的切入点方法（method.invoke(...)）,此代码中没有
     * 解决：Spring框架提供了一个接口，ProceedingJoinPoint。该接口有一个方法proceed()，此方法相当于明确切入点调用方法
     *      该接口可作为环绕通知的方法参数，程序执行时，Spring框架提供该接口的实现类，直接使用即可。
     *
     *  Spring环绕通知，是Spring框架提供的一种可以在代码中控制增强何时执行的方式，与配置方式不同。
     * @return
     */
    public Object around(ProceedingJoinPoint pjp) {
        Object rt = null;
        try {
            Object[] args = pjp.getArgs();  // 获取方法执行所需参数
            System.out.println("增强方法在proceed方法之前，前置通知");
            rt = pjp.proceed(args);  //明确调用业务层方法（切入点方法）
            System.out.println("增强方法在proceed方法之后，后置通知");
        } catch (Throwable throwable) { //此处必须使用Throwable异常进行拦截，Exception无法拦截到
            System.out.println("增强方法在异常中，异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("增强方法在finally类中，最终通知");
        }

        return rt;
    }

    /**
     * 用于动态代理模式实现AOP的测试方法
     */
    public void pringLog() {
        System.out.println("记录日志");
    }

    /**
     * 前置通知
     */
    public void before() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    public void afterReturning() {
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
    public void afterThrowing() {
        System.out.println("异常通知");
    }

    /**
     * 最终通知
     */
    public void after() {
        System.out.println("最终通知");
    }


}
