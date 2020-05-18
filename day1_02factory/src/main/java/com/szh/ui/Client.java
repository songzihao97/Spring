package com.szh.ui;

import com.szh.factory.BeanFactory;
import com.szh.service.AccountService;
import com.szh.service.impl.AccountServiceImpl;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //AccountService accountService=new AccountServiceImpl();
        for(int i=0;i<5;i++){
            AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
