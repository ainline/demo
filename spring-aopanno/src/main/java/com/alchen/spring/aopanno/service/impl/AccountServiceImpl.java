package com.alchen.spring.aopanno.service.impl;

import com.alchen.spring.aopanno.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    /**
     * 模拟账户保存，无参无返回值
     */
    @Override
    public void saveAccount() {
        System.out.println("执行保存");
    }

    /**
     * 模拟账户更新，有参无返回值
     *
     * @param i
     */
    @Override
    public void updateAccount(int i) {

        System.out.println("执行更新" + i);
        int a = i / 0;
    }

    /**
     * 模拟账户删除，无参有返回值
     *
     * @return
     */
    @Override
    public int deleteAccount() {
        System.out.println("执行删除");
        return 0;
    }
}
