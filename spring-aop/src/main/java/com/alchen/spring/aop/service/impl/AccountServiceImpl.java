package com.alchen.spring.aop.service.impl;

import com.alchen.spring.aop.dao.IAccountDao;
import com.alchen.spring.aop.entity.Account;
import com.alchen.spring.aop.service.IAccountService;
import com.alchen.spring.aop.utils.TransactionManager;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao = null;

    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void transfer(String sourceName, String targetName, Float money) {
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            Account targetAccount = accountDao.findAccountByName(targetName);
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            accountDao.updateMoneyByName(sourceAccount);
            int i = 1 / 0;
            accountDao.updateMoneyByName(targetAccount);


    }

    @Override
    public void transferProxy(String sourceName, String targetName, Float money) {

    }
}
