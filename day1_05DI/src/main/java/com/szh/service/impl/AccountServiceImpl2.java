package com.szh.service.impl;

import com.szh.service.AccountService;

import java.util.Date;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("保存了一个对象"+name+","+age+","+birthday);
    }
}
