package com.szh.service.impl;

import com.szh.service.AccountService;

import java.util.Date;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("保存了一个对象"+name+","+age+","+birthday);
    }
}
