package com.szh.factory;

import com.szh.service.AccountService;
import com.szh.service.impl.AccountServiceImpl;

/**
 * 模式工厂类（存在jar包中）
 */
public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
