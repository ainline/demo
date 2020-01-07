package com.alchen.demo.spring.aopxml.service;

/**
 * 模拟账户业务层接口
 */
public interface IAccountService {

    /**
     * 模拟账户保存，无参无返回值
     */
    void saveAccount();

    /**
     * 模拟账户更新，有参无返回值
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟账户删除，无参有返回值
     *
     * @return
     */
    int deleteAccount();
}
