package com.alchen.demo.spring.aop.dao.impl;

import com.alchen.demo.spring.aop.dao.IAccountDao;
import com.alchen.demo.spring.aop.entity.Account;
import com.alchen.demo.spring.aop.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner qr;

    private ConnectionUtil connectionUtil;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    /**
     * 转账方法
     *
     * @param sourceName 转出账户
     * @param targetName 目标账户
     * @param money      金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {

    }

    /**
     * 根据账户名称获取是否存在
     *
     * @param name 账户名
     * @return 账户对象
     */
    @Override
    public Account findAccountByName(String name) {
        List<Account> accountList = null;
        try {
            accountList = qr.query(connectionUtil.getTreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class), name);
            if (accountList == null || accountList.size() < 1) {
                return null;
            } else if (accountList.size() > 1) {
                throw new Exception("账户不唯一");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList.get(0);

    }

    /**
     * 更新金额
     *
     * @param account
     */
    @Override
    public void updateMoneyByName(Account account) {
        try {
            qr.update(connectionUtil.getTreadConnection(),"update account set money = ? where name = ?", account.getMoney(), account.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
