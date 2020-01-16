package com.alchen.spring.jdbctemplate.service.impl;

import com.alchen.spring.jdbctemplate.domain.Account;
import com.alchen.spring.jdbctemplate.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAllAccount() {
        jdbcTemplate.execute("select * from account");
        return null;
    }
}
