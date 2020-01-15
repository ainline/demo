package com.alchen.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private String name;
    private Integer age;
    private Date date;

    private Account account;

    private List<Account> list;
    private Map<String,Account> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public Map<String, Account> getMap() {
        return map;
    }

    public void setMap(Map<String, Account> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", account=" + account +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
