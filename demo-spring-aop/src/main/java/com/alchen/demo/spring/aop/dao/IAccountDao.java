package com.alchen.demo.spring.aop.dao;

import com.alchen.demo.spring.aop.entity.Account;

public interface IAccountDao {

    /**
     * 转账方法
     *
     * @param sourceName 转出账户
     * @param targetName 目标账户
     * @param money      金额
     */
    void transfer(String sourceName, String targetName, Float money);

    /**
     * 根据账户名称获取是否存在
     *
     * @param name 账户名
     * @return 账户对象
     */
    Account findAccountByName(String name);

    /**
     * 更新金额
     *
     * @param account
     */
    void updateMoneyByName(Account account);


}
