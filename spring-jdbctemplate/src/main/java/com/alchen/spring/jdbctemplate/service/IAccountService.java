package com.alchen.spring.jdbctemplate.service;

import com.alchen.spring.jdbctemplate.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAllAccount();

}
