package com.szh.dao.impl;

import com.szh.dao.AccountDao;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户成功");
    }
}
