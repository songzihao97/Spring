package com.szh.dao.impl;

import com.szh.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户成功");
    }
}
