package com.szh.service.impl;

import com.szh.service.AccountService;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("对象被创建了");
    }

    public void  saveAccount(){
        System.out.println("保存了一个对象");
    }
}
