package com.alchen.spring.aop.service;

public interface IAccountService {

    void transfer(String sourceName, String targetName, Float money);

    void transferProxy(String sourceName, String targetName, Float money);
}
