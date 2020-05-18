package com.szh.service.impl;

import com.szh.dao.AccountDao;
import com.szh.dao.impl.AccountDaoImpl;
import com.szh.service.AccountService;


/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao=new AccountDaoImpl();

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
