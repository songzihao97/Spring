package com.szh.service.impl;

import com.szh.dao.AccountDao;
import com.szh.dao.impl.AccountDaoImpl;
import com.szh.factory.BeanFactory;
import com.szh.service.AccountService;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao=new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao)BeanFactory.getBean("accountDao");

    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
